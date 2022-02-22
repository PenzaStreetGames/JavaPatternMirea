package com.penzastreetstudios.task6.fabric_method;

/**
 * Класс сотрудника по чикенбургерам.
 * Умеет готовить чикенбургеры.
 */
public class ChickenburgerEmployee implements IBurgerEmployee {

    @Override
    public IBurger cook() {
        return new Chickenburger();
    }
}
