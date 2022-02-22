package com.penzastreetstudios.task6.fabric_method;

/**
 * Класс сотрудника по гамбургерам.
 * Умеет готовить гамбургеры.
 */
public class HamburgerEmployee implements IBurgerEmployee {

    @Override
    public IBurger cook() {
        return new Hamburger();
    }
}
