package com.penzastreetstudios.task6.abstract_fabric.employeers;

import com.penzastreetstudios.task6.abstract_fabric.IBurgerEmployee;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.IMediumBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ISmallBurger;
import com.penzastreetstudios.task6.abstract_fabric.chicken_bugrers.ChickenPrime;
import com.penzastreetstudios.task6.abstract_fabric.chicken_bugrers.Chickenburger;
import com.penzastreetstudios.task6.abstract_fabric.chicken_bugrers.MacChiken;

/**
 * Класс сотрудника по бургерам из курицы.
 * Умеет готовить чикенбургеры, макчикены и чикен-премьеры.
 */
public class ChickenEmployee implements IBurgerEmployee {

    @Override
    public ISmallBurger cookSmallBurger() {
        return new Chickenburger();
    }

    @Override
    public IMediumBurger cookMediumBurger() {
        return new MacChiken();
    }

    @Override
    public ILargeBurger cookLargeBurger() {
        return new ChickenPrime();
    }
}
