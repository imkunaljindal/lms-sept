package com.example.librarymanagementsystemsept.service;

import com.example.librarymanagementsystemsept.Enum.CardStatus;
import com.example.librarymanagementsystemsept.Enum.Gender;
import com.example.librarymanagementsystemsept.dto.requestDTO.StudentRequest;
import com.example.librarymanagementsystemsept.dto.responsetDTO.LibraryCardReponse;
import com.example.librarymanagementsystemsept.dto.responsetDTO.StudentResponse;
import com.example.librarymanagementsystemsept.model.LibraryCard;
import com.example.librarymanagementsystemsept.repository.StudentRepository;
import com.example.librarymanagementsystemsept.model.Student;
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

        // covert request dto ->> model
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setGender(studentRequest.getGender());
        student.setEmail(studentRequest.getEmail());

        // give a library card
        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);  // set librarycard for student

        Student savedStudent = studentRepository.save(student); // save both student and library card

        // saved model to response dto
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setName(savedStudent.getName());
        studentResponse.setEmail(savedStudent.getEmail());
        studentResponse.setMessage("You have been registered");

        LibraryCardReponse cardReponse = new LibraryCardReponse();
        cardReponse.setCardNo(savedStudent.getLibraryCard().getCardNo());
        cardReponse.setIssueDate(savedStudent.getLibraryCard().getIssueDate());
        cardReponse.setCardStatus(savedStudent.getLibraryCard().getCardStatus());
        studentResponse.setLibraryCardReponse(cardReponse);

        return studentResponse;
    }

    public Student getStudent(int regNo) {

        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
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
