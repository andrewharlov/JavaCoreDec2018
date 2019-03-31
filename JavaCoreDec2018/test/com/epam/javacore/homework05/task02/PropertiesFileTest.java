package com.epam.javacore.homework05.task02;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PropertiesFileTest {

    @Test
    public void test01(){
        Path file = Paths.get("src", "com", "epam", "javacore", "homework05",
                "task02", "movie.properties");
        PropertiesFile propertiesFile = new PropertiesFile(file);

        try {
            propertiesFile.readPropertiesFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String expected = "Sam Lane";
        String actual = "";

        try {
            actual = propertiesFile.getProperty("editor");
        } catch (PropertiesKeyNotFoundException e) {
            System.out.println(e.getMessage());
        }

        assertEquals(expected, actual);
    }


    @Test
    public void test02(){
        Path file = Paths.get("src", "com", "epam", "javacore", "homework05",
                "task02", "movieException.properties");
        PropertiesFile propertiesFile = new PropertiesFile(file);

        try {
            propertiesFile.readPropertiesFile();
            fail("Expected an IOException to be thrown");
        } catch (IOException e) {
            assertThat(e.getMessage().substring(e.getMessage().indexOf('(') + 1,
                    e.getMessage().length() - 1),
                    is("The system cannot find the file specified"));
        }
    }

    @Test
    public void test03(){
        Path file = Paths.get("src", "com", "epam", "javacore", "homework05",
                "task02", "movie.properties");
        PropertiesFile propertiesFile = new PropertiesFile(file);

        try {
            propertiesFile.readPropertiesFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            propertiesFile.getProperty("studio");
            fail("Expected an PropertiesKeyNotFoundException to be thrown");
        } catch (PropertiesKeyNotFoundException e) {
            assertThat(e.getMessage(), is("The property 'studio' was not found."));
        }
    }
}