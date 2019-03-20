package com.epam.javacore.homework04.task02;

import java.io.*;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeAnalyzer {
    public static final List<String> JAVA_KEYWORDS = new ArrayList<>(
            Arrays.asList(
                    "abstract", "for", "continue", "for", "new", "switch",
                    "assert", "default", "goto", "package", "synchronized",
                    "boolean", "do", "if", "private", "this", "break",
                    "double", "implements", "protected", "throw", "byte",
                    "else", "import", "public", "throws", "case", "enum",
                    "instanceof", "return", "transient", "catch", "extends",
                    "int", "short", "try", "char", "final", "interface",
                    "static", "void", "class", "finally", "long", "strictfp",
                    "volatile", "const", "float", "native", "super", "while"
            ));

    public Map<String, Integer> countKeywords(String sourceCode) {
        Map<String, Integer> wordCount = new HashMap<>();
        Pattern pattern = Pattern.compile("[a-z]+");
        Matcher matcher = pattern.matcher(sourceCode);

        while (matcher.find()) {
            String word = matcher.group();
            if (JAVA_KEYWORDS.contains(word)){
                if (wordCount.containsKey(word)) {
                    Integer count = wordCount.get(word);
                    count++;
                    wordCount.put(word, count);
                } else {
                    wordCount.put(word.toLowerCase(), 1);
                }
            }
        }
        return wordCount;
    }

    public String readFile(Path filePath){
        int symbol;
        String content = "";
        File file = new File(filePath.toUri());
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            while ((symbol = fileReader.read()) != -1) {
                content = content + (char) symbol;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return content;
    }

    public void writeFile(Path filePath, String content){
        File file = new File(filePath.toUri());
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
