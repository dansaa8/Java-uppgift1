package org.example;

import java.util.Arrays;

public class Measure {


    private final TimeStamp[] timeStamps = new TimeStamp[24];

    public Measure() {
        createTimestamps();
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

    public String MinMaxAndAverage() {
        return minPrice() + "\n" + maxPrice() + "\nMedelpris: " + average(timeStamps) + " öre";
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
        return "Billigaste pris: " + timeStamps[elem].getValue() + " öre, " + "Klockslag: " + timeStamps[elem].getTime();
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
        return "Dyraste pris: " + timeStamps[elem].getValue() + " öre, " + "Klockslag: " + timeStamps[elem].getTime();
    }

    private int average(TimeStamp[] stamps) {
        int total = 0;
        for (int i = 0; i < stamps.length; i++) {
            total += stamps[i].getValue();
        }
        return total / stamps.length;
    }

    public String lowestToHighest() {
        TimeStamp[] copy = timeStamps.clone();
        Arrays.sort(copy, (first, second) -> {
            if (first.getValue() != second.getValue()) {
                return first.getValue() - second.getValue();
            }
            return first.getTime().compareTo(second.getTime());
        });
        String finalStr = "";
        for (int i = 0; i < copy.length; i++) {
            finalStr += copy[i].getTime() + " " + copy[i].getValue() + " öre\n";
        }
        return finalStr;
    }

    public String cheapestHours() {
        int elem = 0;
        int cheapest = calc4SequentTimeStamps(elem);

        for (int i = 1; i < timeStamps.length - 3; i++) {
            int current = calc4SequentTimeStamps(i);
            if (current < cheapest) {
                cheapest = current;
                elem = i;
            }
        }
        return "Den billigaste tiden att börja ladda är klockan: " + timeStamps[elem].getTime()
                + "\noch medelpriset för 4 timmars laddning är: "
                + average(Arrays.copyOfRange(timeStamps, elem, elem + 3));
    }

    private int calc4SequentTimeStamps(int elem) {
        int total = 0;
        for (int i = 0; i < 4; i++) {
            total += timeStamps[elem].getValue() +
                    timeStamps[elem + 1].getValue() +
                    timeStamps[elem + 2].getValue() +
                    timeStamps[elem + 3].getValue();
        }
        return total;
    }

}
