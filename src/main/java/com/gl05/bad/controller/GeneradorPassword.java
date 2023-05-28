package com.gl05.bad.controller;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GeneradorPassword {
    private static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMERIC_CHARACTERS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{}\\|;:'\",.<>/?";

    public static String generatePassword(int length) {
        String allCharacters = LOWERCASE_CHARACTERS + UPPERCASE_CHARACTERS + NUMERIC_CHARACTERS + SPECIAL_CHARACTERS;
        List<String> characterList = Arrays.asList(allCharacters.split(""));
        Collections.shuffle(characterList);

        StringBuilder passwordBuilder = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterList.size());
            passwordBuilder.append(characterList.get(randomIndex));
        }

        return passwordBuilder.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 12;
        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }
}