package com.hyberlet.task_24.service;

import com.hyberlet.task_24.model.Student;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@ExtendWith(MockitoExtension.class)
public class MailServiceTests {

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private MailService mailService;

    @Test
    public void sendMessage() {
        Student student = new Student();
        student.setFirstName("Aboba");
        student.setLastName("Abobov");

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailService.EMAIL);
        message.setFrom(mailService.EMAIL);
        String subject = "New " + student.getClass().getSimpleName() + " at " +
                LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)) + " " +
                LocalDateTime.now().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM));
        message.setSubject(subject);
        message.setText(student.toString());

        mailService.sendMessage(student);
        Mockito.verify(javaMailSender).send(message);
    }
}
