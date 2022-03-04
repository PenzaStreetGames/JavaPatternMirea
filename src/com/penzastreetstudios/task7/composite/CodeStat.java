package com.penzastreetstudios.task7.composite;

public class CodeStat {

    public int packages;
    public int modules;
    public int lines;

    public CodeStat(int packages, int modules, int lines) {
        this.packages = packages;
        this.modules = modules;
        this.lines = lines;
    }

    public void add(CodeStat codeStat) {
        this.packages += codeStat.packages;
        this.modules += codeStat.modules;
        this.lines += codeStat.lines;
    }

    @Override
    public String toString() {
        return "CodeStat{" +
                "packages=" + packages +
                ", modules=" + modules +
                ", lines=" + lines +
                '}';
    }
}
