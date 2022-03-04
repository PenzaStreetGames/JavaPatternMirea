package com.penzastreetstudios.task7.flyweight;

import java.util.Objects;

public class BurgerType {
    private String name;
    private String description;

    public BurgerType(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void about(int id) {
        System.out.println(name + "(Бургер №" + id + "). " + description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
