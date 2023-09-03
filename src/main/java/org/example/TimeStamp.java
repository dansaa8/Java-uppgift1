package org.example;

public final class TimeStamp {
    private final String time;
    private final int value;

    public TimeStamp(String time, int value) {
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
