package com.example.librarymanagementsystemsept.repository;

import com.example.librarymanagementsystemsept.Enum.Gender;
import com.example.librarymanagementsystemsept.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {

    List<Student> findByGender(Gender gender);

    Student findByEmail(String email);

    Student findByGenderAndEmail(Gender gender, String email);
}
