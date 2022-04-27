package com.hyberlet.task_20.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.hyberlet.task_20.repository")
@EnableAspectJAutoProxy
public class DataConfiguration {

}
