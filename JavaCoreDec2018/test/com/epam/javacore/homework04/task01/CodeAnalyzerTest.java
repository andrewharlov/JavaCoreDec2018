package com.epam.javacore.homework04.task01;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CodeAnalyzerTest {

    @Test
    public void test01(){
        String expected = "package com.epam.javacore.homework02.task03;\r\n" +
                "\r\n" +
                "public class DeskItem {\r\n" +
                "    private String type;\r\n" +
                "    private String brand;\r\n" +
                "    private double price;\r\n" +
                "\r\n" +
                "    public DeskItem(String type, String brandName, double price){\r\n" +
                "        this.type = type;\r\n" +
                "        this.brand = brandName;\r\n" +
                "        this.price = price;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    public String getBrand() {\r\n" +
                "        return brand;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    public double getPrice() {\r\n" +
                "        return price;\r\n" +
                "    }\r\n" +
                "\r\n" +
                "    public String getType() {\r\n" +
                "        return type;\r\n" +
                "    }\r\n" +
                "}";

        Path filePath = Paths.get("src", "com", "epam", "javacore", "homework04", "task01", "source_code.txt");
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        String actual = codeAnalyzer.readFile(filePath);
        actual = actual.replaceAll("ï»¿", ""); //remove Byte Order Mark (BOM)
        assertEquals(expected, actual);
    }

    @Test
    public void test02(){
        Map<String, Integer> expected = new HashMap<>();
        expected.put("private", 3);
        expected.put("package", 1);
        expected.put("public", 5);
        expected.put("double", 3);
        expected.put("this", 3);
        expected.put("class", 1);
        expected.put("return", 3);

        Path filePath = Paths.get("src", "com", "epam", "javacore", "homework04", "task01", "source_code.txt");
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        Map<String, Integer> actual = codeAnalyzer.countKeywords(codeAnalyzer.readFile(filePath));

        assertEquals(expected, actual);
    }

    @Test
    public void test03(){
        String expected = "private - 3\n" +
                "package - 1\n" +
                "public - 5\n" +
                "double - 3\n" +
                "this - 3\n" +
                "class - 1\n" +
                "return - 3\n";

        Path filePath = Paths.get("src", "com", "epam", "javacore", "homework04", "task01", "source_code.txt");
        CodeAnalyzer codeAnalyzer = new CodeAnalyzer();
        Map<String, Integer> foundKeywords = codeAnalyzer.countKeywords(codeAnalyzer.readFile(filePath));

        StringBuilder stringBuilder = new StringBuilder();

        for (Map.Entry<String, Integer> entry : foundKeywords.entrySet()){
            String entryString = entry.getKey() + " - " + entry.getValue() + "\n";
            stringBuilder.append(entryString);
        }

        Path outputFilePath = Paths.get("src", "com", "epam", "javacore", "homework04", "task01", "results.txt");
        codeAnalyzer.writeFile(outputFilePath, stringBuilder.toString());
        String actual = codeAnalyzer.readFile(outputFilePath);
        assertEquals(expected, actual);
    }
}