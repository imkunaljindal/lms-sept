package com.example.librarymanagementsystemsept;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "student_info")
public class Student {

    @Id
    int regNo;

    @Column(name = "student_name")
    Integer name;

    int age;

    String email;

    @Enumerated(EnumType.STRING)
    Gender gender;
}
