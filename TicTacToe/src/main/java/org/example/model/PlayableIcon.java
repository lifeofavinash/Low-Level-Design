package org.example.model;

public enum PlayableIcon {

    CROSS("X"),
    CIRCLE("O");

    private final String value;

    PlayableIcon(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
