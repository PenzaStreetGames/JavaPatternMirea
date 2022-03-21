package com.penzastreetstudios.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProgrammerConfiguration {

    @Bean("Junior")
    public Junior junior() {
        return new Junior();
    }

    @Bean("Middle")
    public Middle middle() {
        return new Middle();
    }

    @Bean("Senior")
    public Senior senior() {
        return new Senior();
    }

}
