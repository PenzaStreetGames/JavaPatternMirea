package com.penzastreetstudios.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        synchronized (System.out) {
            switch (new Scanner(System.in).nextInt()) {
                case 1 -> testMap();
                case 2 -> testSet();
            }
        }
    }

    public static void testMap() {
        SafeMap<Integer, Integer> safeMap = new SafeMap<>();
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: is map empty? : " + safeMap.isEmpty());
            for (int i = 0; i < 10; i++) {
                safeMap.put(i, i + 100);
                System.out.println("Thread 1: putting " + i + " value " + (i + 100) + " in the map");
            }
            for (int i = 9; i >= 0; i--) {
                System.out.println("Thread 1: getting value on key " + i + " in the map : " + safeMap.get(i));
            }
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: is map empty? : " + safeMap.isEmpty());
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 2: check the map size " + safeMap.size());
                safeMap.put(i, i + 200);
                System.out.println("Thread 2: putting " + i + " value " + (i + 200) + " in the map");
            }
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testSet() {
        SafeSet<Integer> safeSet = new SafeSet<>();
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1: is set empty? : " + safeSet.isEmpty());
            for (int i = 0; i < 5; i++) {
                safeSet.add(i);
                System.out.println("Thread 1: putting " + i + " in the set");
            }
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 1: checking item " + i + " in the set : " + safeSet.contains(i));
            }
        });
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2: is set empty? : " + safeSet.isEmpty());
            for (int i = 5; i < 10; i++) {
                System.out.println("Thread 2: check the set size " + safeSet.size());
                safeSet.add(i);
                System.out.println("Thread 2: putting " + i + " in the set");
            }
        });
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
