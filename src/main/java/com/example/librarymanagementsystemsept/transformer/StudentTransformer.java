package com.example.librarymanagementsystemsept.transformer;

import com.example.librarymanagementsystemsept.dto.requestDTO.StudentRequest;
import com.example.librarymanagementsystemsept.dto.responsetDTO.StudentResponse;
import com.example.librarymanagementsystemsept.model.Student;

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

    }
}
