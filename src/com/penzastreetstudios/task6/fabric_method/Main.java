package com.penzastreetstudios.task6.fabric_method;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<IBurgerEmployee> bibaBoba = new ArrayList<>(Arrays.asList(new HamburgerEmployee(),
                new ChickenburgerEmployee()));
        ArrayList<IBurger> burgers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            burgers.add(bibaBoba.get(i % bibaBoba.size()).cook());
        }
        for (IBurger burger : burgers)
            System.out.println(burger.about());
    }
}
