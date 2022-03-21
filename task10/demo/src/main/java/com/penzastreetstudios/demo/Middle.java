package com.penzastreetstudios.demo;

import org.springframework.stereotype.Component;

@Component
public class Middle implements Programmer {
    @Override
    public String doCoding() {
        return "System.out.println(String.format('%s, %s!', 'Hello', 'world'))";
    }
}
