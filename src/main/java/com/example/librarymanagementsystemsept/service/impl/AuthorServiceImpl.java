package com.example.librarymanagementsystemsept.service.impl;

import com.example.librarymanagementsystemsept.model.Author;
import com.example.librarymanagementsystemsept.repository.AuthorRepository;
import com.example.librarymanagementsystemsept.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        Author savedAuthor = authorRepository.save(author);
        return "Author succesfully added!!!";
    }
}
