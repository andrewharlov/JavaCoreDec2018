package com.epam.javacore.homework02.task03;

public class Pen extends DeskItem {
    private String color;
    private int width;

    public Pen(String color, int width, String brandName, double price){
        super(brandName, price);
        this.color = color;
        this.width = width;
    }
}
