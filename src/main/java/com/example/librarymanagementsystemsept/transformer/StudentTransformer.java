package com.example.librarymanagementsystemsept.transformer;

import com.example.librarymanagementsystemsept.dto.requestDTO.StudentRequest;
import com.example.librarymanagementsystemsept.dto.responsetDTO.LibraryCardReponse;
import com.example.librarymanagementsystemsept.dto.responsetDTO.StudentResponse;
import com.example.librarymanagementsystemsept.model.LibraryCard;
import com.example.librarymanagementsystemsept.model.Student;
import lombok.experimental.UtilityClass;


public class StudentTransformer {

    public static Student StudentRequestToStudent(StudentRequest studentRequest){

        return Student.builder()
                .name(studentRequest.getName())
                .age(studentRequest.getAge())
                .email(studentRequest.getEmail())
                .gender(studentRequest.getGender())
                .build();
    }

    public static StudentResponse StudentToStudentResponse(Student student){

        LibraryCardReponse cardReponse = LibraryCardReponse.builder()
                .cardNo(student.getLibraryCard().getCardNo())
                .cardStatus(student.getLibraryCard().getCardStatus())
                .issueDate(student.getLibraryCard().getIssueDate())
                .build();

        return StudentResponse.builder()
                .name(student.getName())
                .email(student.getEmail())
                .libraryCardReponse(cardReponse)
                .build();
    }
}
