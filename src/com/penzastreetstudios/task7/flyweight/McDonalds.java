package com.penzastreetstudios.task7.flyweight;

import java.util.ArrayList;

public class McDonalds {
    public ArrayList<Burger> burgers = new ArrayList<>();

    public void createBurger(String name, String description) {
        BurgerType type = BurgerFactory.getBurgerType(name, description);
        Burger burger = new Burger(type);
        burgers.add(burger);
    }

    public void about() {
        for (Burger burger : burgers)
            burger.about();
    }
}
