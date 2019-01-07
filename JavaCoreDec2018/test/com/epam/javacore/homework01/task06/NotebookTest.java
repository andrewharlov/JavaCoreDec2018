package com.epam.javacore.homework01.task06;

import org.junit.Test;

import static org.junit.Assert.*;

public class NotebookTest {
    @Test
    public void test1(){
        Notebook notebook = new Notebook();
        Note expected = new Note("Testing method 'addNote'.");
        notebook.addNote(expected);
        Note actual = notebook.notes.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        Notebook notebook = new Notebook();
        Note expected = new Note("Testing the method 'editNote'.");
        Note note = new Note("Hey! This is my first note.");
        notebook.addNote(note);
        notebook.editNote(note, "Testing the method 'editNote'.");
        Note actual = notebook.notes.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        Notebook notebook = new Notebook();
        Note note = new Note("Testing the method 'deleteNote'");
        notebook.addNote(note);
        notebook.deleteNote(note);
        boolean expected = false;
        boolean actual = notebook.notes.contains(note);
        assertEquals(expected, actual);
    }

    @Test
    public void test4(){
        Notebook notebook = new Notebook();
        String expected = "Sorry, no notes to display.";
        String actual = notebook.printNotes();
        assertEquals(expected, actual);
    }

    @Test
    public void test5(){
        Notebook notebook = new Notebook();
        Note note = new Note("First note.");
        notebook.addNote(note);
        String expected = "Note #1: First note.\n";
        String actual = notebook.printNotes();
        System.out.println(actual);
        assertEquals(expected, actual);
    }
}