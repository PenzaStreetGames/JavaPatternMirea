package com.penzastreetstudios.task1;

import java.util.Locale;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Predicate<String> emailChecker = (s) -> {
            String template = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*(\\.[a-z]{2,6}|[a-z]{2,6})$";
            return Pattern.matches(template, s.toLowerCase(Locale.ROOT));
        };
        String[] emails = new String[] {
                "crave_ozer_man@mail.ru", "google@google.com", "@", "simple string",
                "email with spaces@mail.ru", ".@.", "_@_", "email-email@mail.ru",
                "mail@ru.com.org.net", "myhost@@@com.ru", "@my.ru", "Julia String",
                "user@example.com", "root@localhost", "CaMeL@CaSe.Ru"
        };
        for (String expression : emails) {
            System.out.println(expression);
            System.out.println("\t" + (emailChecker.test(expression) ? "email" : "not email"));
        }
    }
}
