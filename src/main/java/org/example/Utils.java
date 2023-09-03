package org.example;

import java.util.Scanner;

public final class Utils {
    private Utils() {
    }

    public static int getInt(String from, String to) {
        Scanner scanner = new Scanner(System.in);
        int intValue = 0;
        boolean okInput = false;

        do {
            System.out.println(from + "-" + to + ": ");
            String input = scanner.nextLine();
            try {
                intValue = Integer.parseInt(input);
                okInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("\u001B[31m" + "Ogiltligt värde! Endast heltal godtas" + "\u001B[0m");
            }
        } while (!okInput);

        return intValue;
    }
}
