package com.keremturak.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private JavaMailSender mailSender;
    public MailService(JavaMailSender mailSender){
        this.mailSender = mailSender;
    }
    public String sendMail(String mail,String authCode){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("keremturakstep@gmail.com");
        message.setTo(mail);
        message.setText("Doğrulama Kodunuz :"+authCode);
        mailSender.send(message);
        return "Mail Gönderildi";
    }
}
