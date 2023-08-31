package org.example;

public class Measure {
    private String time;
    private int value;

    public Measure(String time, int value) {
        this.time = time;
        this.value = value;
    }

    public String getTime() {
        return time;
    }

    public int getValue() {
        return value;
    }

}
