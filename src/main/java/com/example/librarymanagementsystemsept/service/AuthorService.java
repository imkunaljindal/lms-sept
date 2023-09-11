package com.example.librarymanagementsystemsept.service;

import com.example.librarymanagementsystemsept.model.Author;
import com.example.librarymanagementsystemsept.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        Author savedAuthor = authorRepository.save(author);
        return "Author succesfully added!!!";
    }
}
