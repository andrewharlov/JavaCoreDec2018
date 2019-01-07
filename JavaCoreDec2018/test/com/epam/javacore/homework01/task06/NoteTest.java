package com.epam.javacore.homework01.task06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {
    @Test
    public void test1(){
        String expected = "Hello! This is a test for the class Note.";
        Note note = new Note(expected);
        String actual = note.getText();
        assertEquals(expected, actual);
    }
}