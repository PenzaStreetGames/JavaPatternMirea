package com.penzastreetstudios.task8.visitor;

public class Monitor implements Reportable {

    public String name;
    public boolean enabled;

    @Override
    public Report getReport(Reporter reporter) {
        return reporter.reportForMonitor(this);
    }

    public Monitor(String name, boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }
}
