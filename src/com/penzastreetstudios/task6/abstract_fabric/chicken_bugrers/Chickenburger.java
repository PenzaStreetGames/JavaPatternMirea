package com.penzastreetstudios.task6.abstract_fabric.chicken_bugrers;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ISmallBurger;

/**
 * Класс чикенбургера.
 * Бургер умеет говорить о себе, мало, но с достоинством.
 */
public class Chickenburger implements ISmallBurger {

    @Override
    public String aboutLittleButWithDignity() {
        return "Обжаренная куриная котлета из сочного куриного мяса, панированная в сухарях, которая подается на " +
                "карамелизованной булочке, заправленной свежим салатом и специальным соусом «МакЧикен».";
    }
}
