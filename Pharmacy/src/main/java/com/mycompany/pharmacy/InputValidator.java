package com.mycompany.pharmacy;

public class InputValidator {
    public static int parseQuantity(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid quantity entered. Please enter a valid number.");
        }
    }
}
