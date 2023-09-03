package org.example;

import java.util.Scanner;

public final class Menu {

    private final String [] options = {
            "1. Inmatning",
            "2. Min, Max och Medel",
            "3. Sortera",
            "4. Bästa Laddningstid (4h)",
            "e. Avsluta"
    };

    public char prompt() {
        String input = "";

        do {
            printOptions();
            input = getInput();
        } while (!isOkInput(input));

        return input.charAt(0);
    };

    private void printOptions() {
        System.out.println("Elpriser");
        System.out.println("========");
        for (String option : options) {
            System.out.println(option);
        }
    };

    private String getInput() {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;
    };

    private boolean isOkInput(String input) {
        if (input.length() == 1) {
            for (String option : options) {
                if (option.substring(0, 1).equals(input)) {
                    return true;
                }
            }
        }
        System.out.println("\u001B[31m" + "Ogiltligt val!" + "\u001B[0m" + "\n");
        return false;
    };
}
