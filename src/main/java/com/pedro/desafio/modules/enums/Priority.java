package com.pedro.desafio.modules.enums;

public enum Priority {
    LOW(3),
    MEDIUM(2),
    HIGH(1);

    private final int level;

    Priority(int level) {
        this.level = level;
    }

    public static Priority fromInt(int value) {
        for (Priority priority : Priority.values()) {
            if (priority.getLevel() == value) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Prioridade inválida: " + value);
    }

    public int getLevel() {
        return level;
    }
}