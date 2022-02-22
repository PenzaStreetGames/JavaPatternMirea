package com.penzastreetstudios.task6.builder;

/**
 * Интерфейс сотрудника.
 * Умеет собирать бургеры.
 */
public interface IEmployee {
    void reset();
    void addBun();
    void addCutlet();
    void addSauce();
    Burger makeBurger();
}
