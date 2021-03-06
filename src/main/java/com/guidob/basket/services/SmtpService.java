package com.guidob.basket.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.guidob.basket.beans.RequestMail;

@Service
public class SmtpService {

    @Autowired
    private JavaMailSender javaMailSender; 
    
    public void send(RequestMail request){
    	SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(request.getFrom());
        message.setTo(request.getTo());
        message.setSubject(request.getSubject());
        message.setText(request.getBody());
        javaMailSender.send(message);
    }
}