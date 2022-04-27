package com.hyberlet.task_21.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableJpaRepositories("com.hyberlet.task_21.repository")
@EnableAspectJAutoProxy
@EnableAsync
public class DataConfiguration {

}
