package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
@RestController
@RequestMapping ("/api/cards")



public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }

    @RequestMapping(path = "/random", method = RequestMethod.GET)
    public CatCard randomCard() {
        CatCard catCard = new CatCard();
        CatPic catPic = catPicService.getPic();
        CatFact catFact = catFactService.getFact();
        catCard.setCatFact(catFact.getText());
        catCard.setImgUrl(catPic.getFile());
        return catCard;


    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public CatCard get(@PathVariable int id) {
        CatCard catcard = catCardDao.get(id);
        if (catcard == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND");
        } else {
            return catCardDao.get(id);
        }
    }

        @RequestMapping(method = RequestMethod.GET)
        public List<CatCard> list() {
            return catCardDao.list();
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean save(@RequestBody CatCard savecatcard) {
        return catCardDao.save(savecatcard);

    }

    @RequestMapping(path = "{id}", method = RequestMethod.PUT)
    public boolean update(@PathVariable int id, @Valid @RequestBody CatCard catcard) {
        return catCardDao.update(id, catcard);

    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void delete (@PathVariable int id){
        catCardDao.delete(id);
    }
}
