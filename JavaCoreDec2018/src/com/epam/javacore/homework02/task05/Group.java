package com.epam.javacore.homework02.task05;

import java.util.HashMap;

public class Group {
    private Subject subject;
    private HashMap<Student, Object> studentMarks;

    public Group(Subject subject) {
        this.studentMarks = new HashMap<>();
        this.subject = subject;
    }

    public void addMark(Student student, double mark){
        if (this.subject.isDecimalMark()){
            this.studentMarks.put(student, (Double) mark);
        } else {
            this.studentMarks.put(student, Integer.valueOf(((Double) mark).intValue()));
        }
    }

    public boolean hasStudent(Student student){
        if (this.studentMarks.containsKey(student)){
            return true;
        }

        return false;
    }

    public HashMap<Student, Object> getStudentMarks() {
        return studentMarks;
    }

    public Subject getSubject() {
        return subject;
    }
}
