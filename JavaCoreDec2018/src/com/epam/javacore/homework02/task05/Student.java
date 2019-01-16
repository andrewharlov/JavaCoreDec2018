package com.epam.javacore.homework02.task05;

public class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Student) {
            Student otherNote = (Student) obj;
            if (this.firstName.equals(otherNote.firstName)
                    && this.lastName.equals(otherNote.lastName)){
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = this.firstName.hashCode() ^ (this.firstName.hashCode() >>> 7);
        result = result ^ (41 * this.lastName.hashCode());
        return  result;
    }
}
