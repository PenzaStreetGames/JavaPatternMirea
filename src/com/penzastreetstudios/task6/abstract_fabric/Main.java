package com.penzastreetstudios.task6.abstract_fabric;

import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ILargeBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.IMediumBurger;
import com.penzastreetstudios.task6.abstract_fabric.burger_interfaces.ISmallBurger;
import com.penzastreetstudios.task6.abstract_fabric.employeers.BeefEmployee;
import com.penzastreetstudios.task6.abstract_fabric.employeers.ChickenEmployee;
import com.penzastreetstudios.task6.fabric_method.IBurger;
import com.penzastreetstudios.task6.abstract_fabric.IBurgerEmployee;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<IBurgerEmployee> bibaBoba = new ArrayList<>(Arrays.asList(new ChickenEmployee(),
                new BeefEmployee()));
        ArrayList<ILargeBurger> largeBurgers = new ArrayList<>();
        ArrayList<IMediumBurger> mediumBurgers = new ArrayList<>();
        ArrayList<ISmallBurger> smallBurgers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            smallBurgers.add(bibaBoba.get(i % bibaBoba.size()).cookSmallBurger());
            mediumBurgers.add(bibaBoba.get(i % bibaBoba.size()).cookMediumBurger());
            largeBurgers.add(bibaBoba.get(i % bibaBoba.size()).cookLargeBurger());
        }
        for (int i = 0; i < smallBurgers.size(); i++) {
            System.out.println(smallBurgers.get(i).aboutLittleButWithDignity());
            System.out.println(mediumBurgers.get(i).aboutNotALotAndNotALittle());
            System.out.println(largeBurgers.get(i).aboutWithASenseOfSuperiority());
        }
    }
}
