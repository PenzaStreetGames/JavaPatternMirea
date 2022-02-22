package com.penzastreetstudios.task6.builder;

/**
 * Класс сотрудника по бигмакам.
 * Почему-то, собирая бургеры, всегда собирает бигмаки.
 */
public class BigMacEmployee implements IEmployee {
    private Burger burger;

    public BigMacEmployee() {
        reset();
    }

    @Override
    public void reset() {
        burger = new Burger();
    }

    @Override
    public void addBun() {
        burger.addIngredient("Sesame bun");
    }

    @Override
    public void addCutlet() {
        burger.addIngredient("Beef cutlet");
    }

    @Override
    public void addSauce() {
        burger.addIngredient("BigMac sauce");
    }

    @Override
    public Burger makeBurger() {
        return burger;
    }
}
