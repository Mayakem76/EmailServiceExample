package kemy.dev.EmailServiceExample.services;

import kemy.dev.EmailServiceExample.entities.Student;
import kemy.dev.EmailServiceExample.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    private Optional<Student>student;
    public void createStudent(@RequestBody Student student){
        studentRepository.save(student);
    }
    public Optional <Student> getStudent(@PathVariable Long id){

        student=studentRepository.findById(id);
        if( student.isPresent())
        return  student;
        return null;
    }


}
