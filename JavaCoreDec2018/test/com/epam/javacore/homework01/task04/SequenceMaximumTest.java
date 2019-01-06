package com.epam.javacore.homework01.task04;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SequenceMaximumTest {
    @Test
    public void test1(){
        int n = 1;
        ArrayList<Double> sequence = new ArrayList<>(Arrays.asList(8.4, 2.0));
        SequenceMaximum sequenceMaximum = new SequenceMaximum();
        double expected = 10.4;
        double actual = sequenceMaximum.max(sequence, n);
        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void test2(){
        int n = 4;
        ArrayList<Double> sequence = new ArrayList<>(Arrays.asList(7.7, 10.3, 3.0, 7.7, 3.1, 2.3, 10.4, 3.9));
        SequenceMaximum sequenceMaximum = new SequenceMaximum();
        double expected = 20.7;
        double actual = sequenceMaximum.max(sequence, n);
        assertEquals(expected, actual, 0.1);
    }
}