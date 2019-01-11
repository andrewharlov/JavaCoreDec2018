package com.epam.javacore.homework02.task03;

public class Scissors extends DeskItem {
    private static final String type = "Scissors";
    private int size;

    public Scissors(int size, String brandName, double price){
        super(type, brandName, price);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "; " +
                "Brand: " + getBrand() + "; " +
                "Price: " + getPrice() + " " +
                "Length: " + this.getSize() + "\n";
    }
}
