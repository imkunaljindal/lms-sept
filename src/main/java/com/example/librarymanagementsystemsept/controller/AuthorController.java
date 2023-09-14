package com.example.librarymanagementsystemsept.controller;

import com.example.librarymanagementsystemsept.model.Author;
import com.example.librarymanagementsystemsept.service.impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorServiceImpl;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody Author author){
        String response = authorServiceImpl.addAuthor(author);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }


    // update the email id of an author  -->> observer lastActivity column

    // Give me the names of all the books written by a partiular author

    // give me the names of authors who have written more than 'x' number of books
}
