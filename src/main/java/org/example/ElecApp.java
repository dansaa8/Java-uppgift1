package org.example;

public class ElecApp {
    char choice;
    Menu menu = new Menu();
    Measure m;

    public ElecApp() {
        do {
            choice = menu.prompt();
            switch(choice) {
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
