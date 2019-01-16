package com.epam.javacore.homework02.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Department {
    private List<Group> groups;

    public Department() {
        this.groups = new ArrayList<>();
    }

    public HashMap<String, String> getStudentScores(Student student) {
        String subjectName = "";
        String score = "";
        HashMap<String, String> scores = new HashMap<>();

        for (Group group : groups) {
            if (group.hasStudent(student)) {
                Object mark = group.getStudentMarks().get(student);

                if (mark instanceof Double) {
                    score = mark.toString();
                } else if (mark instanceof Integer) {
                    score = mark.toString();
                }

                subjectName = group.getSubject().name();
                scores.put(subjectName, score);
            }
        }

        return scores;
    }

    public void addGroup(Group group){
        this.groups.add(group);
    }

    public String studentScoresToString(HashMap<String, String> marks){
        StringBuilder stringBuilder = new StringBuilder();

        for (String key : marks.keySet()) {
            String string = "Subject : " + key + " Mark : " + marks.get(key) + "\n";
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }

    public List<Group> getGroups() {
        return groups;
    }
}
