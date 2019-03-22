package com.epam.javacore.homework04.task04;

import java.io.Serializable;

public class Actor implements Serializable {
    private final static long serialVersionUID = 333;
    private String firstName;
    private String lastName;

    public Actor(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addMovie(Movie movie){
        movie.addActor(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public int hashCode() {
        int result = this.firstName.hashCode() ^ (this.firstName.hashCode() >>> 11);
        result = result ^ (59 * this.lastName.hashCode());
        return  result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj instanceof Actor){
            Actor otherActor = (Actor) obj;

            return this.firstName.equals(otherActor.firstName) &&
                    this.lastName.equals(otherActor.lastName);
        }

        return false;
    }
}
