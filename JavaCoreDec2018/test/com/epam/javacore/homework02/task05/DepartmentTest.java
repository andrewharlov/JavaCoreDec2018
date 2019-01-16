package com.epam.javacore.homework02.task05;

import org.junit.Test;
import java.util.HashMap;
import static org.junit.Assert.*;

public class DepartmentTest {
    @Test
    public void test1(){
        Department department = new Department();
        Group artClass = new Group(Subject.ART);
        department.addGroup(artClass);
        boolean expected = true;
        boolean actual = department.getGroups().contains(artClass);
        assertEquals(expected, actual);
    }

    @Test
    public void test2(){
        Department department = new Department();

        Group musicClass = new Group(Subject.MUSIC);
        Group danceClass = new Group(Subject.DANCE);

        Student andy = new Student("Andrew", "Bananas");
        Student tony = new Student("Tony", "Fast");

        danceClass.addMark(andy, 6.9);
        danceClass.addMark(tony, 3.5);
        musicClass.addMark(andy, 5.2);
        musicClass.addMark(tony, 4.5);

        department.addGroup(musicClass);
        department.addGroup(danceClass);

        HashMap<String, String> expected = new HashMap<>(){{
            put("MUSIC", "5.2");
            put("DANCE", "6");
        }};

        HashMap<String, String> actual = department.getStudentScores(andy);
        assertEquals(expected, actual);
    }

    @Test
    public void test3(){
        Department department = new Department();
        Group sportClass = new Group(Subject.SPORTS);
        Student alfredo = new Student("Alfredo", "Snails");
        sportClass.addMark(alfredo, 2.2);
        department.addGroup(sportClass);
        HashMap<String, String> alfredoScores = department.getStudentScores(alfredo);

        String expected = "Subject : SPORTS Mark : 2\n";
        String actual = department.studentScoresToString(alfredoScores);

        assertEquals(expected, actual);
    }
}