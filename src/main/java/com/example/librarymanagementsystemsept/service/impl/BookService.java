package com.example.librarymanagementsystemsept.service.impl;

import com.example.librarymanagementsystemsept.Enum.Genre;
import com.example.librarymanagementsystemsept.dto.responsetDTO.BookResponse;
import com.example.librarymanagementsystemsept.exception.AuthorNotFoundException;
import com.example.librarymanagementsystemsept.model.Author;
import com.example.librarymanagementsystemsept.model.Book;
import com.example.librarymanagementsystemsept.repository.AuthorRepository;
import com.example.librarymanagementsystemsept.repository.BookRepository;
import com.example.librarymanagementsystemsept.transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String addBook(Book book) {

        // check if author exists or not
        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid author id!!!");
        }

        Author author = authorOptional.get();
        book.setAuthor(author);
        author.getBooks().add(book);

        authorRepository.save(author);  // save both author and book
        return "Book added successfully";

    }

    public List<BookResponse> getBooksByGenreAndCostGreaterThan(String genre, double cost) {

        List<Book> books = bookRepository.getBooksByGenreAndCostGreaterThan(genre,cost);

        // prepare the response. convert model to dto
        List<BookResponse> response = new ArrayList<>();
        for(Book book: books){
            response.add(BookTransformer.BookToBookResponse(book));
        }
        return response;
    }

    public List<BookResponse> getBooksByGenreAndCostGreaterThanHQL(Genre genre, double cost) {

        List<Book> books = bookRepository.getBooksByGenreAndCostGreaterThanHQL(genre,cost);

        // prepare the response. convert model to dto
        List<BookResponse> response = new ArrayList<>();
        for(Book book: books){
            response.add(BookTransformer.BookToBookResponse(book));
        }
        return response;
    }
}
