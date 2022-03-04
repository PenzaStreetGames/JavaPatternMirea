package com.penzastreetstudios.task2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Human> humans = new ArrayList<>(Arrays.asList(
                new Human(18, "Вася", "Пупкин", LocalDate.parse("2003-12-12"), 70),
                new Human(24, "Абоба", "Пожилой", LocalDate.parse("1996-09-14"), 96),
                new Human(19, "Паша", "Соломатин", LocalDate.parse("2002-10-05"), 72),
                new Human(323, "Александр", "Пушкин", LocalDate.parse("1799-06-06"), 75),
                new Human(18, "Виктор", "Пелевин", LocalDate.parse("2003-04-04"), 100)
        ));
        Stream<Human> humanStream = humans.stream();
        int res =
        humanStream
                .peek(System.out::println)
                .sorted((human, human2) -> human2.firstName.charAt(1) - human.firstName.charAt(1))
                .peek(System.out::println)
                .mapToInt(human -> human.age)
                .peek(System.out::println)
                .reduce(1, (int a, int b) -> a * b);
        System.out.println(res);
    }
}
