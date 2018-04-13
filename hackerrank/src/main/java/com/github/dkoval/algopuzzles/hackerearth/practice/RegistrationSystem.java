package com.github.dkoval.algopuzzles.hackerearth.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RegistrationSystem {
    private final Map<String, Integer> logins = new HashMap<>();

    String register(String login) {
        Integer suffix = logins.get(login);
        if (suffix != null) {
            String newLogin;
            do {
                newLogin = login + suffix;
                suffix++;
            } while (logins.containsKey(newLogin));
            logins.put(newLogin, 0);
            logins.put(login, suffix);
            return newLogin;
        } else {
            logins.put(login, 0);
            return login;
        }
    }

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            RegistrationSystem db = new RegistrationSystem();
            while (n-- > 0) {
                String login = in.next();
                login = db.register(login);
                System.out.println(login);
            }
        }
    }
}
