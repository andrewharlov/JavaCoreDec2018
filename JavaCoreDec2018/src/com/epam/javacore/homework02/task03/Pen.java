package com.epam.javacore.homework02.task03;

public class Pen extends DeskItem {
    private static final String type = "Pen";
    private String color;
    private int width;

    public Pen(String color, int width, String brandName, double price){
        super(type, brandName, price);
        this.color = color;
        this.width = width;
    }

    public String getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "; " +
                "Brand: " + getBrand() + "; " +
                "Price: " + getPrice() + " " +
                "Color: " + this.getColor() + "; " +
                "Width: " + this.getWidth() + "\n";
    }
}
