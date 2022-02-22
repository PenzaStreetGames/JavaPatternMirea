package com.penzastreetstudios.task6.prototype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IEmployee biba = new ChikenburgerEmployee();
        biba.addBun();
        biba.addCutlet();
        biba.addSauce();
        biba.addBun();
        Burger burger = biba.makeBurger();
        ArrayList<BurgerPrototype> burgers = new ArrayList<>(List.of(burger));
        for (int i = 0; i < 9; i++) {
            burgers.add(burgers.get(burgers.size() - 1).cloneBurger());
        }
        for (BurgerPrototype burgerPrototype : burgers) {
            System.out.println(burgerPrototype);
        }
    }
}
