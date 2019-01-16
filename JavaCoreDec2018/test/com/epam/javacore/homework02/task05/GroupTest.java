package com.epam.javacore.homework02.task05;

import org.junit.Test;
import static org.junit.Assert.*;

public class GroupTest {
    @Test
    public void test1(){
        Group sportsClass = new Group(Subject.SPORTS);
        Student walter = new Student("Walter", "Rist");
        sportsClass.addMark(walter, 2.5);
        boolean actual = sportsClass.hasStudent(walter);
        assertTrue(actual);
    }

    @Test
    public void test2(){
        Group scienceClass = new Group(Subject.SCIENCE);
        Student jordan = new Student("Jordan", "Pine");
        scienceClass.addMark(jordan, 2.7);
        Object mark = scienceClass.getStudentMarks().get(jordan);
        boolean actual = mark instanceof Double;
        assertTrue(actual);
    }

    @Test
    public void test3(){
        Group artClass = new Group(Subject.ART);
        Student alfred = new Student("Alfred", "Hitchcock");
        artClass.addMark(alfred, 4.8);
        Object mark = artClass.getStudentMarks().get(alfred);
        boolean actual = mark instanceof Integer;
        assertTrue(actual);
    }

    @Test
    public void test4(){
        Group mathClass = new Group(Subject.MATH);
        Student johny = new Student("Johny", "Byte");
        mathClass.addMark(johny, 2.3);

        Object mark = mathClass.getStudentMarks().get(johny);

        int actual = 0;
        int expected = 2;

        if (mark instanceof Integer){
            actual = (Integer) mark;
        }

        assertEquals(expected, actual, 0.1);
    }

    @Test
    public void test5(){
        Group scienceClass = new Group(Subject.SCIENCE);
        Student tenner = new Student("Tenner", "Getter");
        scienceClass.addMark(tenner, 5.5);

        Object mark = scienceClass.getStudentMarks().get(tenner);

        double actual = 0.0;
        double expected = 5.5;

        if (mark instanceof Double){
            actual = (Double) mark;
        }

        assertEquals(expected, actual, 0.1);
    }
}