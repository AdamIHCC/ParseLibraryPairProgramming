package org.example;

public enum Genre {
    DRAMA, YA, ROMANCE_NOVEL, THRILLER;

    public static Genre parseGenre(String genre) {
        return switch (genre) {
            case "DRAMA" -> DRAMA;
            case "YA" -> YA;
            case "ROMANCE_NOVEL" -> ROMANCE_NOVEL;
            case "THRILLER" -> THRILLER;
            default -> null;
        };
    }
}
