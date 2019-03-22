package com.epam.javacore.homework04.task04;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MovieCollection {
    private List<Movie> movies = new ArrayList<>();

    public void addMovie (Movie movie){
        this.movies.add(movie);
    }

    public void removeMovie(Movie movie){
        ListIterator<Movie> iterator = getMovies().listIterator();
        while (iterator.hasNext()){
            if (iterator.next().equals(movie)){
                iterator.remove();
            }
        }
    }

    public void addActor(Movie movie, Actor actor){
        for (Movie nextMovie : getMovies()) {
            if (nextMovie.equals(movie)) {
                nextMovie.addActor(actor);
            }
        }
    }

    public void removeActor(Movie movie, Actor actor){
        for (Movie nextMovie : getMovies()) {
            if (nextMovie.equals(movie)) {
                nextMovie.removeActor(actor);
            }
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void saveMovieCollection(Path filePath){
        File file = new File(filePath.toUri());

        try{
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(movies);

            objectOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMovieCollection(Path filePath){
        File file = new File(filePath.toUri());

        try{
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            movies = (List<Movie>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
