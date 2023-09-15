package com.example.librarymanagementsystemsept.service.impl;

import com.example.librarymanagementsystemsept.Enum.CardStatus;
import com.example.librarymanagementsystemsept.Enum.Gender;
import com.example.librarymanagementsystemsept.dto.requestDTO.StudentRequest;
import com.example.librarymanagementsystemsept.dto.responsetDTO.LibraryCardReponse;
import com.example.librarymanagementsystemsept.dto.responsetDTO.StudentResponse;
import com.example.librarymanagementsystemsept.model.LibraryCard;
import com.example.librarymanagementsystemsept.repository.StudentRepository;
import com.example.librarymanagementsystemsept.model.Student;
import com.example.librarymanagementsystemsept.transformer.LibraryCardTransformer;
import com.example.librarymanagementsystemsept.transformer.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse addStudent(StudentRequest studentRequest) {

        // create object using builder
         Student student = StudentTransformer.StudentRequestToStudent(studentRequest);
         LibraryCard card = LibraryCardTransformer.prepareLibraryCard();

         card.setStudent(student);
         student.setLibraryCard(card);  // set librarycard for student
         Student savedStudent = studentRepository.save(student); // save both student and library card

        // saved model to response dto
         return StudentTransformer.StudentToStudentResponse(savedStudent);
    }

    public StudentResponse getStudent(int regNo) {

        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return StudentTransformer.StudentToStudentResponse(studentOptional.get());
        }
        return null;
    }

    public List<String> getAllMales() {

        List<String> names = new ArrayList<>();
        List<Student> students = studentRepository.findByGender(Gender.MALE);
        for(Student s: students){
            names.add(s.getName());
        }

        return names;
    }

}
