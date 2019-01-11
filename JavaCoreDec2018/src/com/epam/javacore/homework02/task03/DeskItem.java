package com.epam.javacore.homework02.task03;

public class DeskItem {
    private String type;
    private String brand;
    private double price;

    public DeskItem(String type, String brandName, double price){
        this.type = type;
        this.brand = brandName;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
