package kemy.dev.EmailServiceExample.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
@Service
public class EmailServiceWithHtmlText {
    @Autowired
    private JavaMailSender javaMailSender;

    public void sendTo(String email, String title, String text) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
        String htmlMsg = "<h1>Welcome!</h1>" +
                "<h2>You have a new message: </h2>" +
                "<img src='https://img.freepik.com/premium-vector/japanese-people-making-funny-poses_23-2148660324.jpg?w=826' alt='I giapponesi fanno pose divertenti' height='400'>" +
                "<h3>" + text + "</h3>";
        helper.setText(htmlMsg, true);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setFrom("email@gmail.com");//fake address
        javaMailSender.send(mimeMessage);
    }
}
