package com.epam.javacore.homework04.task03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class TextEncoder {
    public String readFile(Path filePath){
        int symbol;
        StringBuilder content = new StringBuilder();
        File file = new File(filePath.toUri());

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((symbol = bufferedReader.read()) != -1) {
                content.append((char) symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }

    public void writeFile(Path filePath, String content){
        File file = new File(filePath.toUri());
        FileOutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, StandardCharsets.UTF_16);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        try {
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.flush();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
