package com.penzastreetstudios.task7.composite;

import java.util.ArrayList;

public class Package implements IComponent {

    private ArrayList<IComponent> components = new ArrayList<>();

    public Package() {
    }

    public Package(ArrayList<IComponent> components) {
        this.components = components;
    }

    public Package add(IComponent component) {
        components.add(component);
        return this;
    }

    public Package remove(IComponent component) {
        components.remove(component);
        return this;
    }

    public ArrayList<IComponent> getComponents() {
        return components;
    }

    @Override
    public CodeStat getCodeStat() {
        CodeStat codeStat = new CodeStat(1, 0, 0);
        for (IComponent component : components) {
            codeStat.add(component.getCodeStat());
        }
        return codeStat;
    }
}
