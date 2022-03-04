package com.penzastreetstudios.task8.visitor;

import java.time.LocalDate;
import java.util.Date;

public class Diagnostics implements Reporter {
    @Override
    public Report reportForPrinter(Printer printer) {
        String name = printer.name;
        LocalDate date = LocalDate.now();
        String state = (printer.printing ? "printing" : "ready");
        int code = printer.printing ? 1 : 0;
        return new Report(name, state, date, code);
    }

    @Override
    public Report reportForMonitor(Monitor monitor) {
        String name = monitor.name;
        LocalDate date = LocalDate.now();
        String state = (monitor.enabled ? "enabled" : "disabled");
        int code = monitor.enabled ? 1 : 0;
        return new Report(name, state, date, code);
    }
}
