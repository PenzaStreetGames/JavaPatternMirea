package com.penzastreetstudios.task8.visitor;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<Reportable> devices = new ArrayList<>(Arrays.asList(
                new Printer("Printer 1", true),
                new Printer("Printer 2", false),
                new Monitor("Monitor 1", true),
                new Monitor("Monitor 2", false)
        ));
        Reporter reporter = new Diagnostics();
        for (Reportable device : devices)
            System.out.println(device.getReport(reporter));
    }
}
