package com.penzastreetstudios.task6.abstract_fabric.chicken_bugrers;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;

/**
 * Класс чикен-премьера.
 * Умеет говорить о себе с чувством превосходства.
 */
public class ChickenPrime implements ILargeBurger {
    @Override
    public String aboutWithASenseOfSuperiority() {
        return "Вкуснейшее рубленое куриное филе в хрустящей панировке, сыр \"Чеддер\", ароматный бекон, " +
                "ломтик помидора, свежий салат, специальный дижонский соус и, конечно, та самая булочка с кунжутом.";
    }
}
