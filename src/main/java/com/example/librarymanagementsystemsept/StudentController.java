package com.example.librarymanagementsystemsept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        Student response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student = studentService.getStudent(regNo);
        if(student!=null){
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!!",HttpStatus.BAD_REQUEST);
    }

    // delete a student --> regNo

    // update the age of a student  ---> regNo, age

    // get all the students in the db

    // get list of all male students
}
