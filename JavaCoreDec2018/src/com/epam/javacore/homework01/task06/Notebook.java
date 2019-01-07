package com.epam.javacore.homework01.task06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * This class represents a notebook
 * @author Andrei Kharlov
 * @version 1.0
 */
public class Notebook {
    /**notes List<Note> This is a list that represents notes in a notebook */
    public List<Note> notes;

    /**
     * Constructor for a notebook
     */
    public Notebook(){
        this.notes = new ArrayList<>();
    }

    /**
     * Adds a note to a notebook
     * @param note Note This is a note to add
     */
    public void addNote(Note note){
        this.notes.add(note);
    }

    /**
     * Changes a note in a notebook
     * @param noteToEdit Note This is a note to edit
     * @param newText String This is a new text for the note
     */
    public void editNote(Note noteToEdit, String newText){
        for (Note currentNote : this.notes){
            if (currentNote.equals(noteToEdit)){
                int index = this.notes.indexOf(currentNote);
                Note newNote = new Note(newText);
                this.notes.set(index, newNote);
            }
        }
    }

    /**
     * Deletes a note from a notebook
     * @param noteToDelete Note This is a note to delete
     */
    public void deleteNote(Note noteToDelete){
        Iterator<Note> iterator = this.notes.iterator();

        while (iterator.hasNext()){
            Note currentNote = iterator.next();
            if (currentNote.equals(noteToDelete)){
                iterator.remove();
            }
        }
    }

    /**
     * Returns all notes from a notebook in a formatted string
     * @return String This is a string with all notes from a notebook
     */
    public String printNotes(){
        StringBuilder notesToPrint = new StringBuilder("");

        for (Note note : this.notes){
            String stringToAppend = "Note #" + (this.notes.indexOf(note) + 1) +  ": " + note.getText() + "\n";
            notesToPrint.append(stringToAppend);
        }

        if (notesToPrint.toString().equals("")){
            notesToPrint.append("Sorry, no notes to display.");
        }

        return notesToPrint.toString();
    }
}
