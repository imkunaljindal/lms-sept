package com.example.librarymanagementsystemsept.transformer;

import com.example.librarymanagementsystemsept.Enum.CardStatus;
import com.example.librarymanagementsystemsept.model.LibraryCard;
import com.example.librarymanagementsystemsept.model.Student;

import java.util.UUID;

public class LibraryCardTransformer {

    public static LibraryCard prepareLibraryCard(){
        return LibraryCard.builder()
                .cardNo(String.valueOf(UUID.randomUUID()))
                .cardStatus(CardStatus.ACTIVE)
                .build();
    }
}
