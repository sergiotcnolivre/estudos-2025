package com.sergio.todo.enums;

public enum PRIORITY {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private final int value;

    PRIORITY(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
