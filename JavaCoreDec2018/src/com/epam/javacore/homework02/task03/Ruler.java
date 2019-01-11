package com.epam.javacore.homework02.task03;

public class Ruler extends DeskItem {
    private static final String type = "Ruler";
    private int length;

    public Ruler(int length, String brandName, double price){
        super(type, brandName, price);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "; " +
                "Brand: " + getBrand() + "; " +
                "Price: " + getPrice() + " " +
                "Length: " + this.getLength() + "\n";
    }
}
