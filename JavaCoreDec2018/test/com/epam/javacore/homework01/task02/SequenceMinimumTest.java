package com.epam.javacore.homework01.task02;

import static org.junit.Assert.*;
import org.junit.Test;

import java.math.BigDecimal;

public class SequenceMinimumTest {
    @Test
    public void test1(){
        SequenceMinimum sequenceMinimum = new SequenceMinimum();
        BigDecimal expectedResult =
                new BigDecimal("0.25");
        BigDecimal actualResult = sequenceMinimum.function(1);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test2(){
        SequenceMinimum sequenceMinimum = new SequenceMinimum();
        BigDecimal expectedResult =
                new BigDecimal("0.00390625");
        BigDecimal actualResult = sequenceMinimum.function(0.004);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void test3(){
        SequenceMinimum sequenceMinimum = new SequenceMinimum();
        BigDecimal expectedResult =
                new BigDecimal("0.00189035916824196602477325956925824357313103973865509033203125");
        BigDecimal actualResult = sequenceMinimum.function(0.002);
        assertEquals(expectedResult, actualResult);
    }
}