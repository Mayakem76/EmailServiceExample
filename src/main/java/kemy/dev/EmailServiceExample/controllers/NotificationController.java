package kemy.dev.EmailServiceExample.controllers;

import kemy.dev.EmailServiceExample.entities.NotificationDto;
import kemy.dev.EmailServiceExample.entities.Student;
import kemy.dev.EmailServiceExample.services.EmailService;
import kemy.dev.EmailServiceExample.services.EmailServiceWithHtmlText;
import kemy.dev.EmailServiceExample.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private EmailService emailService;
    @Autowired
    private EmailServiceWithHtmlText emailServiceWithHtmlText;

    @PostMapping("/sms")
    public ResponseEntity<String> sendNotification(@RequestBody NotificationDto payload){
        try {
            Optional <Student> studentToSendNotification = studentService.getStudent(payload.getStudentId());
            System.out.println("Getting the student: " + studentToSendNotification);
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not found the student");
            }
            if (studentToSendNotification.isPresent())
            emailService.sendTo(studentToSendNotification.get().getEmail(),payload.getTitle(),payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.err.println("Error in notification controller" + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
    @PostMapping("/mime")
    public ResponseEntity<String> mimeNotification (@RequestBody NotificationDto payload){
        try {
            Optional <Student> studentToSendNotification = studentService.getStudent(payload.getStudentId());
            System.out.println("Getting the student: " + studentToSendNotification);
            if (studentToSendNotification == null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Did not found the student");
            }
            emailServiceWithHtmlText.sendTo(studentToSendNotification.get().getEmail(),payload.getTitle(),payload.getText());
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            System.err.println("Error in notification controller" + e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
