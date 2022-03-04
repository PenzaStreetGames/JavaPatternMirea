package com.penzastreetstudios.task7.flyweight;

public class Burger {
    private static int idCounter = 0;
    private BurgerType type;
    private int id;

    public Burger(BurgerType type) {
        this.type = type;
        id = idCounter;
        idCounter++;
    }

    public void about() {
        type.about(id);
    }
}
