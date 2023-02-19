package com.techelevator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.sql.*;
import javax.sql.*;


@SpringBootApplication
@ComponentScan()
public class CatCardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatCardsApplication.class, args);
    }


}
