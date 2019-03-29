package com.epam.javacore.homework05.task01;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class TextFileTest {

    @Test
    public void writeToFile() {
        String expected = "Hello World!";
        Path rootFolder = Paths.get("src", "com", "epam", "javacore", "homework05", "task01", "files");
        FileManager fileManager = new FileManager(rootFolder);
        fileManager.findAllTextFiles();

        TextFile fileToEdit = fileManager.createTextFile(rootFolder, "fileToEdit", ".txt");
        fileToEdit.writeToFile("Hello World!");
        String actual = fileToEdit.readFile();

        assertEquals(expected, actual);

        fileManager.deleteTextFile(fileToEdit);
    }
}