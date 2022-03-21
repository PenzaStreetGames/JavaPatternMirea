package com.penzastreetstudios.demo;

import org.springframework.stereotype.Component;

@Component
public class Junior implements Programmer{
    @Override
    public String doCoding() {
        return "Fuck me!";
    }
}
