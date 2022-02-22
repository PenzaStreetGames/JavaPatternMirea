package com.penzastreetstudios.task6.abstract_fabric.employeers;

import com.penzastreetstudios.task6.abstract_fabric.IBurgerEmployee;
import com.penzastreetstudios.task6.abstract_fabric.beef_burgers.BigMac;
import com.penzastreetstudios.task6.abstract_fabric.beef_burgers.BigTasty;
import com.penzastreetstudios.task6.abstract_fabric.beef_burgers.Hamburger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.IMediumBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ISmallBurger;

/**
 * Класс сотрудника по бургерам из говядины.
 * Умеет готовить гамбургеры, бигмаки и биг-тейсти.
 */
public class BeefEmployee implements IBurgerEmployee {

    @Override
    public ISmallBurger cookSmallBurger() {
        return new Hamburger();
    }

    @Override
    public IMediumBurger cookMediumBurger() {
        return new BigMac();
    }

    @Override
    public ILargeBurger cookLargeBurger() {
        return new BigTasty();
    }
}
