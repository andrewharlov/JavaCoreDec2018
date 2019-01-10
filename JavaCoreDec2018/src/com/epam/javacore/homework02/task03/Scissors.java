package com.epam.javacore.homework02.task03;

public class Scissors extends DeskItem {
    private int size;

    public Scissors(int size, String brandName, double price){
        super(brandName, price);
        this.size = size;
    }
}
