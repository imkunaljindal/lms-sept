package com.example.librarymanagementsystemsept.repository;

import com.example.librarymanagementsystemsept.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
}
