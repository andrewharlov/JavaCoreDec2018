package com.epam.javacore.homework04.task03;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;

public class TextEncoderTest {
    @Test
    public void test01(){
        String expected = "б в г д ж з к л м н п р с т ф х ц ч ш щ а э ы у о я е ё ю и ь ъ й\r\n" +
                "Б В Г Д Ж З К Л М Н П Р С Т Ф Х Ц Ч Ш Щ А Э Ы У О Я Е Ё Ю И Ь Ъ Й";

        Path filePath = Paths.get("src", "com", "epam", "javacore",
                "homework04", "task03", "russian_alphabet.txt");

        TextEncoder textEncoder = new TextEncoder();
        String actual = textEncoder.readFile(filePath);

        actual = actual.replace("\ufeff", "");//remove Byte Order Mark (BOM)
        assertEquals(expected, actual);
    }

    @Test
    public void test02(){
        String expected = "б в г д ж з к л м н п р с т ф х ц ч ш щ а э ы у о я е ё ю и ь ъ й\r\n" +
                "Б В Г Д Ж З К Л М Н П Р С Т Ф Х Ц Ч Ш Щ А Э Ы У О Я Е Ё Ю И Ь Ъ Й";

        Path filePathResult = Paths.get("src", "com", "epam", "javacore",
                "homework04", "task03", "results.txt");
        Path filePath = Paths.get("src", "com", "epam", "javacore",
                "homework04", "task03", "russian_alphabet.txt");

        TextEncoder textEncoder = new TextEncoder();
        String rusianAlphabet = textEncoder.readFile(filePath);
        textEncoder.writeFile(filePathResult, rusianAlphabet);

        File file = new File(filePathResult.toUri());
        InputStreamReader inputStreamReader = null;
        String actual = "";

        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_16);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            int symbol;
            while ((symbol = bufferedReader.read()) != -1){
                actual = actual + (char) symbol;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        actual = actual.replace("\ufeff", "");//remove Byte Order Mark (BOM)
        assertEquals(expected, actual);
    }
}