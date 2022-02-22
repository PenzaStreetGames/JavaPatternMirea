package com.penzastreetstudios.task6.abstract_fabric.chicken_bugrers;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.IMediumBurger;

/**
 * Класс макчикена.
 * Умеет говорить о себе не много и не мало.
 */
public class MacChiken implements IMediumBurger {
    @Override
    public String aboutNotALotAndNotALittle() {
        return "Булочка карамелизированная с семенами кунжута, обжаренная куриная котлета из сочного куриного мяса, " +
                "специальный соус «МакЧикен» и салат айсберг.";
    }
}
