package org.example;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MeasureCollection {
 private Measure[] measures = new Measure[24];
 private Scanner scanner = new Scanner(System.in);

    public MeasureCollection() {
        createMeasures();
        for (Measure measure : measures) {
            System.out.println("Time: " + measure.getTime());
            System.out.println("Value: " + measure.getValue());
        }
    }

    private void createMeasures() {
        System.out.println("Skriv in ett värde i öre för varje klockslag. Endast siffror i heltal");

        for (int i = 0; i < measures.length; i++) {
            String from = i < 10 ? "0" + i : Integer.toString(i);
            String to = i + 1 < 10 ? "0" + (i + 1) : Integer.toString(i + 1);
            int userInput = getInput(from, to);
            measures[i] = new Measure(from + "-" + to, userInput);
        }
    }

    private int getInput(String from, String to) {
        int intValue = 0;
        boolean okInput = false;

        do {
            System.out.println(from + "-" +  to + ": ");
            String input = scanner.nextLine();
            try {
                intValue = Integer.parseInt(input);
                okInput = true;
            }
            catch(NumberFormatException nfe) {
                System.out.println("\u001B[31m" + "Ogiltligt värde! Endast heltal godtas" + "0m\u001B[0m");
            }
        } while(!okInput);

        return intValue;
    }
}
