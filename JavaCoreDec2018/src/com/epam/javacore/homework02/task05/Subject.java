package com.epam.javacore.homework02.task05;

enum Subject {
    MATH(false),
    ART(false),
    SCIENCE(true),
    MUSIC(true),
    DANCE(false),
    SPORTS(false);

    private boolean decimalMark;

    Subject(boolean decimal) {
        this.decimalMark = decimal;
    }

    public boolean isDecimalMark(){
        return this.decimalMark;
    }
}
