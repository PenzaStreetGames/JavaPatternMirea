package com.penzastreetstudios.task8.visitor;

public interface Reporter {
    Report reportForPrinter(Printer printer);
    Report reportForMonitor(Monitor monitor);
}
