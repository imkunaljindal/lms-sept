package com.example.librarymanagementsystemsept.dto.responsetDTO;

import com.example.librarymanagementsystemsept.Enum.CardStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LibraryCardReponse {

    String cardNo;

    CardStatus cardStatus;

    Date issueDate;
}
