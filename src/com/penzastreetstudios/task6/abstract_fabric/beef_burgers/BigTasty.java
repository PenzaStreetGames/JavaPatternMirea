package com.penzastreetstudios.task6.abstract_fabric.beef_burgers;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;

/**
 * Класс бургера биг-тейсти.
 * Умеет говорить о себе с чувством превосходства.
 */
public class BigTasty implements ILargeBurger {
    @Override
    public String aboutWithASenseOfSuperiority() {
        return "Это сандвич с большим, рубленым бифштексом из 100% говядины на большой булочке с кунжутом. " +
                "Особенный вкус сандвичу придают три кусочка сыра «эмменталь», два ломтика помидора, свежий салат, " +
                "лук и соус \"Биг Тейсти\" с дымком.";
    }
}
