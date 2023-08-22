package com.qa.util;

import java.util.Random;

public class EmailGenerator {
    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz1234567890";
        int emailLength = 10; // You can adjust the length as needed
        StringBuilder email = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < emailLength; i++) {
            int randomIndex = random.nextInt(allowedChars.length());
            char randomChar = allowedChars.charAt(randomIndex);
            email.append(randomChar);
        }

        return email.toString();
    }

    // Generate a valid email with real domain name
    public static String generateValidEmail() {
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "example.com"};
        Random random = new Random();
        int randomDomainIndex = random.nextInt(domains.length);
        return generateRandomEmail() + "@" + domains[randomDomainIndex];
    }
}
