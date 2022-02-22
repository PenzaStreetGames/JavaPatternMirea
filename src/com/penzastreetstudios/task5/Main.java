package com.penzastreetstudios.task5;

public class Main {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        System.out.println("Singleton 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Singleton1.getInstance() == Singleton1.getInstance());
        }
        System.out.println();
        System.out.println("Singleton 2:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Singleton2.getInstance() == Singleton2.getInstance());
        }
        System.out.println();
        System.out.println("Singleton 3:");
        for (int i = 0; i < 5; i++) {
            System.out.println(Singleton3.getInstance() == Singleton3.getInstance());
        }
        System.out.println();
    }
}
