package com.epam.javacore.homework01.task05;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayXTest {
    @Test
    public void test1(){
        int [][] expected = new int[][]{
                {1}
        };

        ArrayX arrayX = new ArrayX();
        int [][] actual = arrayX.createArray(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test2(){
        int [][] expected = new int[][]{
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };

        ArrayX arrayX = new ArrayX();
        int [][] actual = arrayX.createArray(3);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test3(){
        int [][] expected = new int[][]{
                {1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 0},
                {0, 1, 0, 1, 0},
                {1, 0, 0, 0, 1}
        };

        ArrayX arrayX = new ArrayX();
        int [][] actual = arrayX.createArray(5);
        assertArrayEquals(expected, actual);
    }
}