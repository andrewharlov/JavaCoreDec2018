package com.epam.javacore.homework01.task06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Notebook {
    public List<Note> notes;

    public Notebook(){
        this.notes = new ArrayList<>();
    }

    public void addNote(Note note){
        this.notes.add(note);
    }

    public void editNote(Note noteToEdit, String newText){
        for (Note currentNote : this.notes){
            if (currentNote.equals(noteToEdit)){
                int index = this.notes.indexOf(currentNote);
                Note newNote = new Note(newText);
                this.notes.set(index, newNote);
            }
        }
    }

    public void deleteNote(Note noteToDelete){
        Iterator<Note> iterator = this.notes.iterator();

        while (iterator.hasNext()){
            Note currentNote = iterator.next();
            if (currentNote.equals(noteToDelete)){
                iterator.remove();
            }
        }
    }

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
