package com.example.studentmanagement.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmanagement.model.Student;

@RestController
public class StudentController {

    @GetMapping("/students")
    public List<Student> getStudents() {
        return Arrays.asList(
            new Student(101, "Jaswanth"),
            new Student(102, "Rahul"),
            new Student(103, "Priya")
        );
    }
}
