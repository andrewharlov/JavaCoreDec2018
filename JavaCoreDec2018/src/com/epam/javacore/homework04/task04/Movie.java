package com.epam.javacore.homework04.task04;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Movie implements Serializable {
    private final static long serialVersionUID = 444;
    private String title;
    private List<Actor> actors;

    public Movie(String title){
        this.title = title;
        actors = new ArrayList<>();
    }

    public void addActor(Actor actor){
        this.actors.add(actor);
    }

    public void removeActor(Actor actor){
        ListIterator<Actor> iterator = getActors().listIterator();
        while (iterator.hasNext()){
            Actor nextActor = iterator.next();
            if (actor.equals(nextActor)){
                iterator.remove();
            }
        }
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        StringBuilder cast = new StringBuilder("Cast:\n");

        for (Actor actor : getActors()){
            String actors = actor.toString() + "\n";
            cast.append(actors);
        }

        return "Title: " + getTitle() + "\n" + cast.toString();
    }

    @Override
    public int hashCode() {
        return this.title.hashCode() ^ (this.title.hashCode() >>> 11);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj instanceof Movie){
            Movie otherMovie = (Movie) obj;

            return this.title.equals(otherMovie.title);
        }

        return false;
    }
}
