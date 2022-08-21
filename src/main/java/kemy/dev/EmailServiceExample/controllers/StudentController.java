package kemy.dev.EmailServiceExample.controllers;

import kemy.dev.EmailServiceExample.entities.Student;
import kemy.dev.EmailServiceExample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public void createStudent(@RequestBody Student student){
        studentService.createStudent(student);
    }
    @GetMapping("/{id}")
    public String getStudent(@PathVariable Long id){
        return String.valueOf(studentService.getStudent(id));
    }
}
