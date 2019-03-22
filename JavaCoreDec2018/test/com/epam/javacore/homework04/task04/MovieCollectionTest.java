package com.epam.javacore.homework04.task04;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class MovieCollectionTest {

    @Test
    public void test01(){
        String expected = "Title: Death Proof\n" +
                "Cast:\n" +
                "Jordan Ladd\n" +
                "Eli Roth\n" +
                "Omar Doom\n" +
                "Title: Infinity War\n" +
                "Cast:\n" +
                "Chris Evans\n" +
                "Mark Ruffalo\n" +
                "Josh Brolin\n";

        Movie deathProof = new Movie("Death Proof");
        Movie infinityWar = new Movie("Infinity War");

        Actor jordan = new Actor("Jordan", "Ladd");
        Actor eli = new Actor("Eli", "Roth");
        Actor omar = new Actor("Omar", "Doom");
        Actor chris = new Actor("Chris", "Evans");
        Actor mark = new Actor("Mark", "Ruffalo");
        Actor josh = new Actor("Josh", "Brolin");

        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(deathProof);
        movieCollection.addMovie(infinityWar);

        movieCollection.addActor(deathProof, jordan);
        movieCollection.addActor(deathProof, eli);
        movieCollection.addActor(deathProof, omar);

        movieCollection.addActor(infinityWar, chris);
        movieCollection.addActor(infinityWar, mark);
        movieCollection.addActor(infinityWar, josh);

        Path filePath = Paths.get("src", "com", "epam", "javacore", "homework04", "task04", "db.ser");

        movieCollection.saveMovieCollection(filePath);
        movieCollection.readMovieCollection(filePath);

        StringBuilder fileContent = new StringBuilder();

        for (Movie movie : movieCollection.getMovies()){
            fileContent.append(movie.toString());
        }

        String actual = fileContent.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void test02(){
        String expected = "Title: Infinity War\n" +
                "Cast:\n" +
                "Mark Ruffalo\n" +
                "Josh Brolin\n" +
                "Stan Lee\n" +
                "Title: The Kid\n" +
                "Cast:\n" +
                "Jacob Browne\n";

        Movie deathProof = new Movie("Death Proof");
        Movie infinityWar = new Movie("Infinity War");

        Actor jordan = new Actor("Jordan", "Ladd");
        Actor eli = new Actor("Eli", "Roth");
        Actor omar = new Actor("Omar", "Doom");

        Actor chris = new Actor("Chris", "Evans");
        Actor mark = new Actor("Mark", "Ruffalo");
        Actor josh = new Actor("Josh", "Brolin");

        MovieCollection movieCollection = new MovieCollection();

        movieCollection.addMovie(deathProof);
        movieCollection.addMovie(infinityWar);

        movieCollection.addActor(deathProof, jordan);
        movieCollection.addActor(deathProof, eli);
        movieCollection.addActor(deathProof, omar);

        movieCollection.addActor(infinityWar, chris);
        movieCollection.addActor(infinityWar, mark);
        movieCollection.addActor(infinityWar, josh);

        Path filePath = Paths.get("src", "com", "epam", "javacore", "homework04", "task04", "db.ser");

        movieCollection.saveMovieCollection(filePath);
        movieCollection.readMovieCollection(filePath);

        movieCollection.removeMovie(deathProof);
        movieCollection.removeActor(infinityWar, chris);
        movieCollection.addActor(infinityWar, new Actor("Stan", "Lee"));
        movieCollection.addMovie(new Movie("The Kid"));
        movieCollection.addActor(new Movie("The Kid"), new Actor("Jacob", "Browne"));

        movieCollection.saveMovieCollection(filePath);
        movieCollection.readMovieCollection(filePath);

        StringBuilder fileContent = new StringBuilder();

        for (Movie movie : movieCollection.getMovies()){
            fileContent.append(movie.toString());
        }

        String actual = fileContent.toString();
        assertEquals(expected, actual);
    }

}