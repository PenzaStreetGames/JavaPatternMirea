package com.penzastreetstudios.task7.flyweight;

import java.util.ArrayList;
import java.util.Objects;

public class BurgerFactory {

    private static ArrayList<BurgerType> burgerTypes = new ArrayList<>();

    static BurgerType getBurgerType(String name, String description) {
        BurgerType type = null;
        for (BurgerType existingType : burgerTypes) {
            if (name.equals(existingType.getName()) && description.equals(existingType.getDescription())) {
                type = existingType;
                break;
            }
        }
        if (type == null)
            type = new BurgerType(name, description);
        return type;
    }

}
