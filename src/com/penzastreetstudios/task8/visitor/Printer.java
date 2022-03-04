package com.penzastreetstudios.task8.visitor;

public class Printer implements Reportable {

    public String name;
    public boolean printing;

    @Override
    public Report getReport(Reporter reporter) {
        return reporter.reportForPrinter(this);
    }

    public Printer(String name, boolean printing) {
        this.name = name;
        this.printing = printing;
    }
}
