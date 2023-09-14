package com.example.librarymanagementsystemsept.transformer;

import com.example.librarymanagementsystemsept.dto.responsetDTO.BookResponse;
import com.example.librarymanagementsystemsept.model.Book;

public class BookTransformer {

    public static BookResponse BookToBookResponse(Book book){

        return BookResponse.builder()
                .authorName(book.getAuthor().getName())
                .cost(book.getCost())
                .genre(book.getGenre())
                .noOfPages(book.getNoOfPages())
                .title(book.getTitle())
                .build();
    }
}
