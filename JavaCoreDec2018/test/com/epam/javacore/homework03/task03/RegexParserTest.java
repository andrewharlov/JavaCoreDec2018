package com.epam.javacore.homework03.task03;

import org.junit.Test;

import static org.junit.Assert.*;

public class RegexParserTest {
    @Test
    public void isSequentialTest1(){
        String text = "Test test test (Рис. 1) more tEsT (рис. 2) another test (Рис. 3) and (рис. 4).";
        RegexParser regexParser = new RegexParser();
        boolean expected = true;
        boolean actual = regexParser.isSequential(text);
        assertEquals(expected, actual);
    }

    @Test
    public void isSequentialTest2(){
        String text = "Test test test (Рис. 1) more tEsT.";
        RegexParser regexParser = new RegexParser();
        boolean expected = true;
        boolean actual = regexParser.isSequential(text);
        assertEquals(expected, actual);
    }

    @Test
    public void isSequentialTest3(){
        String text = "Test test test (Рис. 1) (Рис. 2)";
        RegexParser regexParser = new RegexParser();
        boolean expected = true;
        boolean actual = regexParser.isSequential(text);
        assertEquals(expected, actual);
    }

    @Test
    public void isSequentialTest4(){
        String text = "Test test test (Рис. 1) more tEsT (рис. 1) another test (Рис. 3) and (рис. 3).";
        RegexParser regexParser = new RegexParser();
        boolean expected = false;
        boolean actual = regexParser.isSequential(text);
        assertEquals(expected, actual);
    }

    @Test
    public void isSequentialTest5(){
        String text = "Test test test (Рис. 1) more tEsT (рис. 3) another test (Рис. 4) and (рис. 5).";
        RegexParser regexParser = new RegexParser();
        boolean expected = false;
        boolean actual = regexParser.isSequential(text);
        assertEquals(expected, actual);
    }

    @Test
    public void getSentencesTest1(){
        String text = "Test test test (Рис. 2) more tEsTs here. " +
                "Second sentence is here. " +
                "Oh really (Рис. 9) draw on on felt." +
                "Joy see first like make are. " +
                "Lets test this (рис. 4) sentence too. " +
                "Thoughts in Neglected (Рис. 66) formerly of mrs Chicken mrs though. " +
                "Dejection there mean every would." +
                "Good besides inhabiting sent garden all any. " +
                "Test test test (рис. 3).";

        String expected = "Test test test (Рис. 2) more tEsTs here.\n" +
                "Oh really (Рис. 9) draw on on felt.\n" +
                "Lets test this (рис. 4) sentence too.\n" +
                "Thoughts in Neglected (Рис. 66) formerly of mrs Chicken mrs though.\n" +
                "Test test test (рис. 3).\n";

        RegexParser regexParser = new RegexParser();
        String actual = regexParser.getSentences(text);
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}