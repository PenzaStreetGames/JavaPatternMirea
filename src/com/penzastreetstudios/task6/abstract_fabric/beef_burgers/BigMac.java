package com.penzastreetstudios.task6.abstract_fabric.beef_burgers;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.IMediumBurger;

/**
 * Класс бигмака.
 * Умеет говорить о себе не много и не мало.
 */
public class BigMac implements IMediumBurger {

    @Override
    public String aboutNotALotAndNotALittle() {
        return "Большой бургер с двумя рублеными бифштексами из 100% говядины на булочке с кунжутом, поджаренной " +
                "в тостере, маринованными огурчиками, луком, свежим салатом «Айсберг», ломтиком плавленого сыра " +
                "«Чеддер» и специальным соусом «Биг Мак».";
    }
}
