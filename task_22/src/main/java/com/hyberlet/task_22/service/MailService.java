package com.hyberlet.task_22.service;

import com.hyberlet.task_22.config.DataConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Service
public class MailService {
    public final String EMAIL = "gamba232@yandex.ru";
    @Autowired
    private DataConfiguration dataConfiguration;
    private JavaMailSender javaMailSender;

    @PostConstruct
    private void mailSettings() {
        javaMailSender = dataConfiguration.getJavaMailSender();
    }

    @Async
    public void sendMessage(Object o) throws MailException {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(EMAIL);
        message.setFrom(EMAIL);
        String subject = "New " + o.getClass().getSimpleName() + " at " +
                LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + " " +
                LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        message.setSubject(subject);
        message.setText(o.toString());

        javaMailSender.send(message);
    }

}
