package org.example;

public final class ElecApp {
    private char choice;
    private final Menu menu = new Menu();
    private Measure m;

    public ElecApp() {
        m = new Measure("Measure.csv");
        do {
            choice = menu.prompt();
            switch (choice) {
                case '1':
                    m = new Measure();
                    break;
                case '2':
                    System.out.println(m.MinMaxAndAverage() + "\n");
                    break;
                case '3':
                    System.out.println(m.lowestToHighest());
                    break;
                case '4':
                    System.out.println(m.cheapestHours());
                    break;

            }
        } while (choice != 'e');


    }
}
