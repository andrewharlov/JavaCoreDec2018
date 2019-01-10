package com.epam.javacore.homework02.task03;

import java.util.ArrayList;
import java.util.List;

public class BeginnerPack {
    private List<DeskItem> deskItems;

    public BeginnerPack(){
        this.deskItems = new ArrayList<DeskItem>();
    }

    public BeginnerPack(ArrayList<DeskItem> deskItems){
        this.deskItems = deskItems;
    }

    public void addDeskItem(DeskItem deskItem){
        this.deskItems.add(deskItem);
    }
}
