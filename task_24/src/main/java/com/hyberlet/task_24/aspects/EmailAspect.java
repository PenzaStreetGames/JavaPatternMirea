package com.hyberlet.task_24.aspects;

import com.hyberlet.task_24.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class EmailAspect {
    @Autowired
    private ApplicationContext context = new AnnotationConfigApplicationContext();
    private MailService mailService;

    @PostConstruct
    public void settingMailService() {
        mailService = context.getBean(MailService.class);
    }

    @After("creationServiceMethods()")
    public void sendMail(JoinPoint joinPoint) {
        System.out.println(Arrays.toString(joinPoint.getArgs()));
        mailService.sendMessage(joinPoint.getArgs()[0]);
    }

    @Pointcut("@annotation(com.hyberlet.task_24.annotations.Mailable)")
    public void creationServiceMethods() {}
}
