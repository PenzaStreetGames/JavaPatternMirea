package com.penzastreetstudios.task6.builder;

/**
 * Класс сотрудника по чикенбургерам.
 * Почему-то, собирая бургеры, всегда собирает чикенбургеры.
 */
public class ChikenburgerEmployee implements IEmployee {
    private Burger burger;

    public ChikenburgerEmployee() {
        reset();
    }

    @Override
    public void reset() {
        burger = new Burger();
    }

    @Override
    public void addBun() {
        burger.addIngredient("Bun");
    }

    @Override
    public void addCutlet() {
        burger.addIngredient("Chicken cutlet");
    }

    @Override
    public void addSauce() {
        burger.addIngredient("MacChiken sauce");
    }

    @Override
    public Burger makeBurger() {
        return burger;
    }
}
