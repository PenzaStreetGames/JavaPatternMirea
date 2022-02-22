package com.penzastreetstudios.task6.prototype;

import java.util.ArrayList;

/**
 * Класс бургера.
 * Собирается из ингредиентов: булочек, котлет и соусов
 * Всегда вкусный
 */
public class Burger implements BurgerPrototype {
    private ArrayList<String> ingredients = new ArrayList<>();

    public Burger() {}

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder().append("Burger:\n");
        for (int i = ingredients.size() - 1; i >= 0; i--) {
            String ingredient = ingredients.get(i);
            res.append("\t").append(ingredient).append("\n");
        }
        return res.toString();
    }

    @Override
    public BurgerPrototype cloneBurger() {
        Burger burger = new Burger();
        burger.ingredients.addAll(ingredients);
        return burger;
    }
}
