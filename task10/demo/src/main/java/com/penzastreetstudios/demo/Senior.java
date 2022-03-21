package com.penzastreetstudios.demo;

import org.springframework.stereotype.Component;

@Component
public class Senior implements Programmer {
    @Override
    public String doCoding() {
        return "Fuck you!";
    }
}
