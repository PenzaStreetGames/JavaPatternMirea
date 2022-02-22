package com.penzastreetstudios.task6.fabric_method;

/**
* Класс чикенбургера - подвида бургеров.
 * Умеет говорить о себе.
* */
public class Chickenburger implements IBurger {

    @Override
    public String about() {
        return "Обжаренная куриная котлета из сочного куриного мяса, панированная в сухарях, которая подается на " +
                "карамелизованной булочке, заправленной свежим салатом и специальным соусом «МакЧикен».";
    }
}
