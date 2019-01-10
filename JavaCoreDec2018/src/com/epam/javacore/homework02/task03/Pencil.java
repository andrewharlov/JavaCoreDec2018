package com.epam.javacore.homework02.task03;

public class Pencil extends DeskItem {
    private String hardness;

    public Pencil(String hardness, String brandName, double price){
        super(brandName, price);
        this.hardness = hardness;
    }
}
