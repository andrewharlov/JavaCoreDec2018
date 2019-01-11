package com.epam.javacore.homework02.task03;

public class Pencil extends DeskItem {
    private static final String type = "Pencil";
    private String hardness;

    public Pencil(String hardness, String brandName, double price){
        super(type, brandName, price);
        this.hardness = hardness;
    }

    public String getHardness() {
        return hardness;
    }

    @Override
    public String toString() {
        return "Type: " + getType() + "; " +
                "Brand: " + getBrand() + "; " +
                "Price: " + getPrice() + " " +
                "Hardness: " + this.getHardness() + "\n";
    }
}
