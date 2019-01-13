package com.epam.javacore.homework02.task02;

import com.epam.javacore.homework02.task03.Pen;
import com.epam.javacore.homework02.task03.Pencil;
import com.epam.javacore.homework02.task03.Ruler;
import com.epam.javacore.homework02.task03.Scissors;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    @Test
    public void test1(){
        Employee john = new Employee();
        Pen pen = new Pen("yellow", 2, "Zorro", 1.99);
        john.addDeskItem(pen, 1);
        boolean expected = true;
        boolean actual = john.getDeskItems().contains(pen);
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        Employee john = new Employee();

        Pencil pencil = new Pencil("HB", "Kohinoor", 1.50);
        Ruler ruler = new Ruler(15, "TTC", 0.99);
        Scissors scissors = new Scissors(5, "Ocean", 3.99);

        john.addDeskItem(pencil, 1);
        john.addDeskItem(ruler, 2);
        john.addDeskItem(scissors, 4);

        double expected = 19.44;
        double actual = john.getCost();

        assertEquals(expected, actual, 2);
    }

    @Test
    public void test3(){
        Employee tony = new Employee();
        Pen pen = new Pen("green", 3, "Jungle", 5.99);
        tony.addDeskItem(pen, 1);
        String actual = tony.deskItemsToString();
        String expected = "Type: Pen; Brand: Jungle; Price: 5.99 Color: green; Width: 3\n";
        assertEquals(expected, actual);
    }
}