package com.penzastreetstudios.task5;

public class Singleton1 {
    private static final Singleton1 instance = new Singleton1();

    private Singleton1() {}

    public static synchronized Singleton1 getInstance() {
        return instance;
    }
}
