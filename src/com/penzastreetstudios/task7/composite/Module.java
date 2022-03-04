package com.penzastreetstudios.task7.composite;

public class Module implements IComponent{

    public int lines;

    public Module(int lines) {
        this.lines = lines;
    }

    @Override
    public CodeStat getCodeStat() {
        return new CodeStat(0, 1, lines);
    }
}
