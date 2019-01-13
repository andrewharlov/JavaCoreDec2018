package com.epam.javacore.homework02.task02;

import com.epam.javacore.homework02.task03.*;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private List<DeskItem> deskItems;

    public Employee(){
        this.deskItems = new ArrayList<DeskItem>();
    }

    public double getCost(){
        double cost = 0;

        for (DeskItem item : this.deskItems){
            cost += item.getPrice();
        }
        //only two decimal places (E.g. 10.55 )
        return Math.floor(cost * 100) / 100;
    }

    public void addDeskItem(DeskItem deskItem, int amount){
        if (amount != 0){
            for (int i = 1; i <= amount; i++){
                this.deskItems.add(deskItem);
            }
        }
    }

    public String deskItemsToString(){
        StringBuilder stringBuilder = new StringBuilder();

        for (DeskItem item : this.deskItems){
            stringBuilder.append(item.toString());
        }

        return stringBuilder.toString();
    }

    public List<DeskItem> getDeskItems() {
        return deskItems;
    }
}
