package org.example;

public final class ElecApp {
    private char choice;
    private final Menu menu = new Menu();
    private Measure m;

    public ElecApp() {}

    public void run() {
        m = new Measure();
        m.createTimeStamps("Measure.csv");
        do {
            choice = menu.prompt();
            switch (choice) {
                case '1' -> {m = new Measure(); m.createTimestamps();}
                case '2' -> System.out.println(m.MinMaxAndAverage() + "\n");
                case '3' -> System.out.println(m.lowestToHighest());
                case '4' -> System.out.println(m.cheapestHours());
            }
        } while (choice != 'e');
    }
}
