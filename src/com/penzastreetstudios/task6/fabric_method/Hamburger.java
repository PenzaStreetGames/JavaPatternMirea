package com.penzastreetstudios.task6.fabric_method;

/**
* Класс гамбургера - подвида бургеров.
* Умеет говорить о себе.
* */
public class Hamburger implements IBurger {

    @Override
    public String about() {
        return "Рубленый бифштекс из 100% говядины, приправленный солью и перцем на гриле, карамелизованная булочка " +
                "с кетчупом, горчицей, луком и маринованным огурчиком.";
    }
}
