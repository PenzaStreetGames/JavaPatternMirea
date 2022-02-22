package com.penzastreetstudios.task6.prototype;

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
