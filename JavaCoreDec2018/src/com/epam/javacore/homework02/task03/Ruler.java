package com.epam.javacore.homework02.task03;

public class Ruler extends DeskItem {
    private int length;

    public Ruler(int length, String brandName, double price){
        super(brandName, price);
        this.length = length;
    }
}
