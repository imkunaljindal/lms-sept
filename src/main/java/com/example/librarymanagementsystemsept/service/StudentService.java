package com.example.librarymanagementsystemsept.service;

import com.example.librarymanagementsystemsept.Enum.CardStatus;
import com.example.librarymanagementsystemsept.model.LibraryCard;
import com.example.librarymanagementsystemsept.repository.StudentRepository;
import com.example.librarymanagementsystemsept.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public String addStudent(Student student) {
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);  // set librarycard for student
        Student savedStudent = studentRepository.save(student); // save both student and library card
        return "Student saved successfully";
    }

    public Student getStudent(int regNo) {

        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }
}
