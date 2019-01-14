package com.epam.javacore.homework02.task03;

import com.epam.javacore.homework02.task04.Sort;

import java.util.*;

public class BeginnerPack implements Sort {
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

    @Override
    public void sortByPrice() {
        Collections.sort(this.deskItems, new Comparator<DeskItem>() {
            @Override
            public int compare(DeskItem item1, DeskItem item2) {
                if (item1.getPrice() == item2.getPrice()){
                    return 0;
                }
                return item1.getPrice() < item2.getPrice() ? -1 : 1;
            }
        });
    }

    @Override
    public void sortByName() {
        Collections.sort(this.deskItems, Comparator.comparing(DeskItem::getBrand));
    }

    @Override
    public void sortByNameAndPrice() {
        Collections.sort(this.deskItems, new Comparator<DeskItem>() {
            @Override
            public int compare(DeskItem item1, DeskItem item2) {
                int result1 = item1.getBrand().compareTo(item2.getBrand());

                if (result1 == 0){
                    if (item1.getPrice() == item2.getPrice()){
                        return 0;
                    }
                    return item1.getPrice() < item2.getPrice() ? -1 : 1;
                }

                return result1;
            }
        });
    }

    public String deskItemsToString(){
        StringBuilder stringBuilder = new StringBuilder();

        for (DeskItem item : this.deskItems){
            stringBuilder.append(item.toString());
        }

        return stringBuilder.toString();
    }
}
