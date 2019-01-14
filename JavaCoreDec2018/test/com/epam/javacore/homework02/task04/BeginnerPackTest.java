package com.epam.javacore.homework02.task04;

import com.epam.javacore.homework02.task03.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class BeginnerPackTest {
    @Test
    public void test1(){
        BeginnerPack beginnerPack = new BeginnerPack();

        Scissors scissors = new Scissors(5, "Ocean", 1.88);
        Pen pen = new Pen("blue", 2, "Zorro", 0.99);
        Pencil pencil = new Pencil("HB", "Kohinoor", 1.50);

        beginnerPack.addDeskItem(scissors);
        beginnerPack.addDeskItem(pen);
        beginnerPack.addDeskItem(pencil);

        beginnerPack.sortByPrice();

        String expected = "Type: Pen; Brand: Zorro; Price: 0.99 Color: blue; Width: 2\n" +
                "Type: Pencil; Brand: Kohinoor; Price: 1.5 Hardness: HB\n" +
                "Type: Scissors; Brand: Ocean; Price: 1.88 Length: 5\n";

        String actual = beginnerPack.deskItemsToString();
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        BeginnerPack beginnerPack = new BeginnerPack();

        Ruler ruler = new Ruler(15, "TTC", 0.99);
        Scissors scissors = new Scissors(5, "Ocean", 1.88);
        Pen pen = new Pen("blue", 2, "Zorro", 0.99);
        Pencil pencil = new Pencil("HB", "Kohinoor", 1.50);

        beginnerPack.addDeskItem(ruler);
        beginnerPack.addDeskItem(scissors);
        beginnerPack.addDeskItem(pen);
        beginnerPack.addDeskItem(pencil);

        beginnerPack.sortByName();

        String expected = "Type: Pencil; Brand: Kohinoor; Price: 1.5 Hardness: HB\n" +
                "Type: Scissors; Brand: Ocean; Price: 1.88 Length: 5\n" +
                "Type: Ruler; Brand: TTC; Price: 0.99 Length: 15\n" +
                "Type: Pen; Brand: Zorro; Price: 0.99 Color: blue; Width: 2\n";

        String actual = beginnerPack.deskItemsToString();
        assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        BeginnerPack beginnerPack = new BeginnerPack();

        Pen pen1 = new Pen("yellow", 2, "Zorro", 1.99);
        Ruler ruler = new Ruler(15, "TTC", 0.99);
        Scissors scissors1 = new Scissors(5, "Ocean", 3.46);
        Scissors scissors2 = new Scissors(5, "Ocean", 3.31);
        Pen pen2 = new Pen("blue", 2, "Zorro", 0.99);
        Pencil pencil = new Pencil("HB", "Kohinoor", 1.50);
        Scissors scissors3 = new Scissors(5, "Ocean", 1.88);

        beginnerPack.addDeskItem(pen1);
        beginnerPack.addDeskItem(ruler);
        beginnerPack.addDeskItem(scissors1);
        beginnerPack.addDeskItem(scissors2);
        beginnerPack.addDeskItem(pen2);
        beginnerPack.addDeskItem(pencil);
        beginnerPack.addDeskItem(scissors3);

        beginnerPack.sortByNameAndPrice();

        String expected = "Type: Pencil; Brand: Kohinoor; Price: 1.5 Hardness: HB\n" +
                "Type: Scissors; Brand: Ocean; Price: 1.88 Length: 5\n" +
                "Type: Scissors; Brand: Ocean; Price: 3.31 Length: 5\n" +
                "Type: Scissors; Brand: Ocean; Price: 3.46 Length: 5\n" +
                "Type: Ruler; Brand: TTC; Price: 0.99 Length: 15\n" +
                "Type: Pen; Brand: Zorro; Price: 0.99 Color: blue; Width: 2\n" +
                "Type: Pen; Brand: Zorro; Price: 1.99 Color: yellow; Width: 2\n";

        String actual = beginnerPack.deskItemsToString();
        assertEquals(expected, actual);
    }
}