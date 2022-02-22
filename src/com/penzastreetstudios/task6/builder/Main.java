package com.penzastreetstudios.task6.builder;

public class Main {
    public static void main(String[] args) {
        IEmployee biba = new ChikenburgerEmployee(), boba = new BigMacEmployee();
        biba.addBun();
        biba.addCutlet();
        biba.addSauce();
        biba.addBun();
        Burger burger = biba.makeBurger();
        System.out.println(burger);
        boba.addBun();
        boba.addCutlet();
        boba.addSauce();
        boba.addBun();
        boba.addCutlet();
        boba.addSauce();
        boba.addBun();
        burger = boba.makeBurger();
        System.out.println(burger);
    }
}
