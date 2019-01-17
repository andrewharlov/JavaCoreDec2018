package com.epam.javacore.homework02.task06;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShipTest {
    @Test
    public void test1(){
        Ship ship = new Ship("Model 3");
        String expected = "Model 3 puts out 450 horsepower ...";
        String actual = ship.launch();
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        Ship ship = new Ship("Georgia");
        Ship.Engine engine = ship.new Engine(200);
        int expected = 200;
        int actual = engine.getHorsepower();
        assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        Ship ship = new Ship("Charlotte");
        String expected = "Charlotte";
        String actual = ship.getName();
        assertEquals(expected, actual);
    }
}