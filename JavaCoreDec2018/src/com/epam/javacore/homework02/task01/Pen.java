package com.epam.javacore.homework02.task01;

public class Pen {
    private String color;
    private int width;

    public Pen(String color, int width){
        this.color = color;
        this.width = width;
    }

    @Override
    public int hashCode() {
        int result = this.color.hashCode() ^ (this.color.hashCode() >>> 11);
        result = result ^ (59 * this.width);
        return  result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj instanceof Pen){
            Pen otherPen = (Pen) obj;

            if (this.color.equals(otherPen.color) && this.width == otherPen.width){
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Pen has " + this.color + " color and the width equals to " + this.width;
    }
}
