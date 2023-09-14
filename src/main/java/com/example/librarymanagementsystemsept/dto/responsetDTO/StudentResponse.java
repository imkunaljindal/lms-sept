package com.example.librarymanagementsystemsept.dto.responsetDTO;

import com.example.librarymanagementsystemsept.model.LibraryCard;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentResponse {

    String name;

    String email;

    LibraryCardReponse libraryCardReponse;
}
