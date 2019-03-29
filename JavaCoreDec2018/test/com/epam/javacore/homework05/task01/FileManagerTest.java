package com.epam.javacore.homework05.task01;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class FileManagerTest {

    @Test
    public void findAllTextFiles() {
        String expected = "textFile3.txt\n" +
                "textFile4.txt\n" +
                "textFile5.txt\n" +
                "textFile2.txt\n" +
                "textFile1.txt\n";

        Path rootFolder = Paths.get("src", "com", "epam", "javacore", "homework05", "task01", "files");
        FileManager fileManager = new FileManager(rootFolder);
        fileManager.findAllTextFiles();
        StringBuilder foundFileNames = new StringBuilder();

        for (TextFile textFile : fileManager.getTextFiles()){
            String fileName = textFile.getPath().getFileName().toString() + "\n";
            foundFileNames.append(fileName);
        }

        String actual = foundFileNames.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void createFile() {
        String expected = "textFile3.txt\n" +
                "textFile4.txt\n" +
                "textFile5.txt\n" +
                "textFile2.txt\n" +
                "textFile1.txt\n" +
                "createTEST.txt\n";

        Path rootFolder = Paths.get("src", "com", "epam", "javacore", "homework05", "task01", "files");
        FileManager fileManager = new FileManager(rootFolder);
        fileManager.findAllTextFiles();

        TextFile createdFile = fileManager.createTextFile(rootFolder, "createTEST", ".txt");
        if (createdFile != null){
            fileManager.getTextFiles().add(createdFile);
        }

        StringBuilder foundFileNames = new StringBuilder();

        for (TextFile textFile : fileManager.getTextFiles()){
            String fileName = textFile.getPath().getFileName().toString() + "\n";
            foundFileNames.append(fileName);
        }

        String actual = foundFileNames.toString();
        assertEquals(expected, actual);

        fileManager.deleteTextFile(createdFile);
    }

    @Test
    public void deleteFile() {
        String expected = "textFile3.txt\n" +
                "textFile4.txt\n" +
                "textFile5.txt\n" +
                "textFile2.txt\n" +
                "textFile1.txt\n";

        Path rootFolder = Paths.get("src", "com", "epam", "javacore", "homework05", "task01", "files");
        FileManager fileManager = new FileManager(rootFolder);
        fileManager.findAllTextFiles();

        TextFile createdFile = fileManager.createTextFile(rootFolder, "TEST", ".txt");
        if (createdFile != null){
            fileManager.getTextFiles().add(createdFile);
        }

        fileManager.deleteTextFile(createdFile);
        StringBuilder foundFileNames = new StringBuilder();

        for (TextFile textFile : fileManager.getTextFiles()){
            String fileName = textFile.getPath().getFileName().toString() + "\n";
            foundFileNames.append(fileName);
        }

        String actual = foundFileNames.toString();
        assertEquals(expected, actual);
    }
}