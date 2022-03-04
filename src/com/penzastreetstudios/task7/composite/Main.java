package com.penzastreetstudios.task7.composite;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        IComponent myProject = new Package()
                .add(new Module(100))
                .add(new Package()
                        .add(new Module(35))
                        .add(new Module(60))
                        .add(new Package()
                                .add(new Module(25))
                                .add(new Module(24)))
                        .add(new Package())
                        .add(new Package()
                                .add(new Module(83))))
                .add(new Module(87));
        System.out.println(myProject.getCodeStat());
    }
}
