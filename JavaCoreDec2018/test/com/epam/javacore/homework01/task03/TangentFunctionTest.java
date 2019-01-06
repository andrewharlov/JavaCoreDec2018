package com.epam.javacore.homework01.task03;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class TangentFunctionTest {
    @Test
    public void test1(){
        TangentFunction tangentFunction = new TangentFunction();
        List<Double> expected = new ArrayList<Double>(Arrays.asList(
                -2.3516391725409136, -3.635859928661581,
                4.2446066160948055, -2.6993677579760966,
                -4.137313712337686, -0.7628390557752578));
        List<Double> actual = new ArrayList<>();
        for (double i = 5; i <= 10; i += 1){
            actual.add(tangentFunction.function(i));
        }
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        TangentFunction tangentFunction = new TangentFunction();
        List<Double> expected = new ArrayList<Double>(Arrays.asList(
                -2.3516391725409136, -228.95084645419513,
                -3.635859928661581, -2.5369788670635103, 4.2446066160948055));
        List<Double> actual = new ArrayList<>();
        for (double i = 5; i <= 7; i += 0.5){
            actual.add(tangentFunction.function(i));
        }
        assertEquals(expected, actual);
    }
}