package com.example.librarymanagementsystemsept.dto.responsetDTO;

import com.example.librarymanagementsystemsept.Enum.Genre;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookResponseDto {

    String title;

    int noOfPages;

    Genre genre;

    double cost;

    String authorName;
}
