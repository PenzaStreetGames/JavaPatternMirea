package com.penzastreetstudios.task5;

public class Singleton3 {
    private static volatile Singleton3 instance;

    public static Singleton3 getInstance() {
        Singleton3 localInstance = instance;
        if (localInstance == null) {
            synchronized (Singleton3.class) {
                localInstance = instance;
                if (localInstance == null) {
                    localInstance = new Singleton3();
                    instance = localInstance;
                }
            }
        }
        return localInstance;
    }
}
