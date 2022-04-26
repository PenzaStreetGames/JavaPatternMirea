package com.hyberlet.task_19.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.hyberlet.task_19.repository")
public class DataConfiguration {

}
