package com.epam.javacore.homework01.task06;

public class Note {
    public String text;

    public Note(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj instanceof Note) {
            Note otherNote = (Note) obj;
            if (this.text.equals(otherNote.text)){
                return true;
            }
        }

        return false;
    }
}
