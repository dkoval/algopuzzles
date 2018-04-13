package com.github.dkoval.algopuzzles.hackerearth.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {
    private final Map<String, Integer> logins = new HashMap<>();

    String register(String login) {
        Integer suffix = logins.get(login);
        if (suffix != null) {
            String newLogin;
            do {
                newLogin = login + suffix++;
            } while (logins.containsKey(newLogin));
            logins.put(newLogin, 0);
            logins.put(login, suffix);
            return newLogin;
        } else {
            logins.put(login, 0);
            return login;
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(in.readLine());
            RegistrationSystem db = new RegistrationSystem();
            while (n-- > 0) {
                String login = in.readLine();
                login = db.register(login);
                System.out.println(login);
            }
        }
    }
}
