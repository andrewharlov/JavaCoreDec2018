package com.epam.javacore.homework05.task01;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class TextFile {
    private Path path;

    public TextFile(Path path){
        this.path = path;
    }

    public void writeToFile(String text){
        try (FileWriter fileWriter = new FileWriter(this.path.toString(), true)){
            fileWriter.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String readFile(){
        int symbol;
        String content = "";
        File file = new File(this.path.toUri());
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);
            StringBuilder stringBuilder = new StringBuilder();

            while ((symbol = fileReader.read()) != -1) {
                stringBuilder.append((char) symbol);
            }

            content = stringBuilder.toString();
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

    public Path getPath() {
        return path;
    }

    @Override
    public int hashCode() {
        int result = this.path.hashCode() ^ (this.path.hashCode() >>> 11);
        result = result ^ (59 * this.path.hashCode());
        return  result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (obj instanceof TextFile){
            TextFile otherTextFile = (TextFile) obj;

            if (this.path.getFileName().toString()
                    .equals(otherTextFile.path.getFileName().toString())){
                return true;
            }
        }

        return false;
    }
}
