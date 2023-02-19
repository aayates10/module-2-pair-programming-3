package com.techelevator.controller;

import com.techelevator.dao.CatCardDao;
import com.techelevator.model.CatCard;
import com.techelevator.model.CatFact;
import com.techelevator.model.CatPic;
import com.techelevator.services.CatFactService;
import com.techelevator.services.CatPicService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class CatController {

    private CatCardDao catCardDao;
    private CatFactService catFactService;
    private CatPicService catPicService;

    public CatController(CatCardDao catCardDao, CatFactService catFactService, CatPicService catPicService) {
        this.catCardDao = catCardDao;
        this.catFactService = catFactService;
        this.catPicService = catPicService;
    }


    @RequestMapping(path = "/api/cards", method = RequestMethod.GET)
    public List<CatCard> list(){
        return catCardDao.list();

    }
    @RequestMapping(path = "/api/cards/{id}" , method = RequestMethod.GET)
    public CatCard get(@PathVariable int id){
        CatCard catcard = catCardDao.get(id);
        if (catcard == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"NOT FOUND");
        }else {
            return catCardDao.get(id);
        }
    }
    @RequestMapping(path = "/api/cards/random", method = RequestMethod.GET)
    public CatCard randomCard(){
        CatPic catPic = catPicService.getPic();
        CatFact catFact = catFactService.getFact();
        CatCard catCard = new CatCard();
        catCard.setCatFact(catFact.getText());
        catCard.setImgUrl(catPic.getFile());
        return catCard;
    }




}
