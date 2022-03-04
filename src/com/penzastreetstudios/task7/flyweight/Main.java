package com.penzastreetstudios.task7.flyweight;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        McDonalds mac = new McDonalds();
        ArrayList<String> names = new ArrayList<>(Arrays.asList(
                "MacChicken", "BigMac"
        ));
        ArrayList<String> descriptions = new ArrayList<>(Arrays.asList(
                "Булочка карамелизированная с семенами кунжута, обжаренная куриная котлета из сочного куриного мяса, " +
                        "специальный соус «МакЧикен» и салат айсберг.",
                "Большой бургер с двумя рублеными бифштексами из 100% говядины на булочке с кунжутом, поджаренной " +
                        "в тостере, маринованными огурчиками, луком, свежим салатом «Айсберг», ломтиком плавленого сыра " +
                        "«Чеддер» и специальным соусом «Биг Мак»."
        ));
        for (int i = 0; i < names.size(); i++) {
            for (int j = 0; j < 10; j++) {
                mac.createBurger(names.get(i), descriptions.get(i));
            }
        }
        mac.about();
    }
}
