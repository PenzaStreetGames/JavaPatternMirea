package com.hyberlet.task_21.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Service
public class MailService {
    public final String EMAIL = "gamba232@yandex.ru";
    private final JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

//    @PostConstruct
//    private void mailSettings() {
//        javaMailSender.setHost("pop.mail.ru");
//        javaMailSender.setUsername("crave_ozer_man@mail.ru");
//        javaMailSender.setPassword("gamba232");
//        javaMailSender.setPort(995);
//        javaMailSender.setProtocol("pop3");
//    }

    @Async
    public void sendMessage(Object o) throws MailException {
        System.out.println("aboba1");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EMAIL);
        message.setFrom(EMAIL);
        message.setSubject("New " + o.getClass().getSimpleName() + " at " +
                LocalDateTime.now());
        message.setText(o.toString());

        javaMailSender.send(message);

        System.out.println("aboba");
    }

}
