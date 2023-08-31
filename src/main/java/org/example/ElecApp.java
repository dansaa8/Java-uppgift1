package org.example;

public class ElecApp {
    char choice;
    Menu menu = new Menu();
    MeasureCollection m;

    public ElecApp() {
        do {
            choice = menu.prompt();
            switch(choice) {
                case '1':
                    m = new MeasureCollection();
                    break;
                case '2':
                    break;
                case '3':
                    break;
                case '4':
                    break;
            }
        } while (choice != 'e');


    }
}
