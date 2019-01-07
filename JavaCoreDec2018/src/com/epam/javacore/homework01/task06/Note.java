package com.epam.javacore.homework01.task06;

/**
 * This class represents a note in a notebook
 * @author Andrei Kharlov
 * @version 1.0
 */
public class Note {
    /** text String This is a text of a note*/
    public String text;

    /**
     * Class constructor for a note
     * @param text String This is a text for a note
     */
    public Note(String text) {
        this.text = text;
    }

    /**
     * Returns a text of a note
     * @return String This is a text a note
     */
    public String getText() {
        return this.text;
    }

    /**
     * Checks whether some other object is "equal to" this one
     * @return boolean True if two objects have the same value in the field 'text'
     */
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
