package com.penzastreetstudios.task6.abstract_fabric;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.IMediumBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ISmallBurger;

/**
 * Интерфейс сотрудника по бургерам.
 * Умеет готовить бургеры, всякие разные. Большие, средние, маленькие.
 */
public interface IBurgerEmployee {
    ISmallBurger cookSmallBurger();
    IMediumBurger cookMediumBurger();
    ILargeBurger cookLargeBurger();
}
