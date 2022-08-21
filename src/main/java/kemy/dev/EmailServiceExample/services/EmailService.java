package kemy.dev.EmailServiceExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;
    public void sendTo(String email, String title, String text) {
        SimpleMailMessage sms = new SimpleMailMessage();
        // sms.setFrom("kemy.dev.test@gmail.com");
        // sms.setReplyTo("kemy.dev.test@gmail.com");
        sms.setTo(email);
        sms.setSubject(title);
        sms.setText(text);
        emailSender.send(sms);
    }
}
