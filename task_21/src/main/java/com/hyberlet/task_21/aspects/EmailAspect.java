package com.hyberlet.task_21.aspects;

import com.hyberlet.task_21.config.DataConfiguration;
import com.hyberlet.task_21.service.MailService;
import lombok.Data;
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
        mailService.sendMessage(joinPoint.getArgs());
    }

    @Pointcut("@annotation(com.hyberlet.task_21.annotations.Mailable)")
    public void creationServiceMethods() {}
}
