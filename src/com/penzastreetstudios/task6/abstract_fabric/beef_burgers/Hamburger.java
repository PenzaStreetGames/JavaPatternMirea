package com.penzastreetstudios.task6.abstract_fabric.beef_burgers;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ISmallBurger;

/**
 * Класс гамбургера.
 * Бургер умеет говорить о себе, мало, но с достоинством.
 */
public class Hamburger implements ISmallBurger {

    @Override
    public String aboutLittleButWithDignity() {
        return "Рубленый бифштекс из 100% говядины, приправленный солью и перцем на гриле, карамелизованная булочка " +
                "с кетчупом, горчицей, луком и маринованным огурчиком.";
    }
}
