package org.example;

import java.util.Arrays;

public class Measure {


    private final TimeStamp[] timeStamps = new TimeStamp[24];

    public Measure() {
        createTimestamps();
    }

    public String MinMaxAndAverage() {
        return minPrice() + "\n" + maxPrice() + "\n" + averagePrice();
    }

    private String minPrice() {
        int min = timeStamps[0].getValue();
        int elem = 0;
        for (int i = 1; i < timeStamps.length; i++) {
            if (min > timeStamps[i].getValue()) {
                min = timeStamps[i].getValue();
                elem = i;
            }
        }
        return "Billigaste pris: " + timeStamps[elem].getValue() + " öre, " +  "Klockslag: " + timeStamps[elem].getTime();
    }

    private String maxPrice() {
        int max = timeStamps[0].getValue();
        int elem = 0;
        for (int i = 1; i < timeStamps.length; i++) {
            if (max < timeStamps[i].getValue()) {
                max = timeStamps[i].getValue();
                elem = i;
            }
        }
        return "Dyraste pris: " + timeStamps[elem].getValue() + " öre, " +  "Klockslag: " + timeStamps[elem].getTime();
    }

    private String averagePrice() {
        int total = 0;
        for (int i = 0; i < timeStamps.length; i++) {
            total += timeStamps[i].getValue();
        }
        return "Medelpris: " + (total / timeStamps.length) + " öre";
    }

    public String lowestToHighest() {
        TimeStamp [] copy = timeStamps.clone();
        Arrays.sort(copy, (first, second) -> {
            if (first.getValue() != second.getValue()) {
                return first.getValue() - second.getValue();
            }
            return first.getTime().compareTo(second.getTime());
        });
        String finalStr = "";
        for (int i = 0; i < copy.length; i++) {
            finalStr += copy[i].getTime() + " " + copy[i].getValue() + "öre\n";
        }
        return finalStr;
    }

    private void createTimestamps() {
        System.out.println("Skriv in ett värde i öre för varje klockslag. Endast siffror i heltal");

        for (int i = 0; i < timeStamps.length; i++) {
            String from = i < 10 ? "0" + i : Integer.toString(i);
            String to = i + 1 < 10 ? "0" + (i + 1) : Integer.toString(i + 1);
            int userInput = Utils.getInt(from, to);
            timeStamps[i] = new TimeStamp(from + "-" + to, userInput);
        }
    }

}
