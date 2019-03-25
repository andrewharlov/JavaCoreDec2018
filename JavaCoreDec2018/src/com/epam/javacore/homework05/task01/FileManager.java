package com.epam.javacore.homework05.task01;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private List<TextFile> textFiles = new ArrayList<>();
    private Path rootFolder;

    public FileManager(Path rootFolder){
        this.rootFolder = rootFolder;
    }

    public void findAllTextFiles(){
        /*
        * TODO
        * textFiles.clear();*/

        File root = new File(rootFolder.toUri());

        FilenameFilter textFilter = new FilenameFilter() {
            public boolean accept(File directory, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        listFilesForFolder(root, textFilter);
    }

    public void listFilesForFolder(File folder, FilenameFilter textFilter) {
        boolean filteredFiles = false;

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry, textFilter);
            } else if (!filteredFiles){
                for (File entry : folder.listFiles(textFilter)) {
                    Path path = Paths.get(entry.getAbsolutePath());
                    textFiles.add(new TextFile(path));
                }

                filteredFiles = true;
            }
        }
    }

    public void deleteTextFile(TextFile fileToDelete){
        // find file in textFiles
        // get file's path
        // delete file by path

        /*
        * TODO
        * Delete fileToDelete from the file system*/

        /*Iterator<TextFile> iterator = textFiles.iterator();
        while (iterator.hasNext()){
            TextFile textFile = iterator.next();
            if (fileToDelete.equals(textFile)){
                iterator.remove();
            }
        }*/
    }

    public TextFile createTextFile(Path folder){
        // create a text file in folder
        // return TextFile object

        return null;
    }

    public static void main(String[] args){
        Path rootFolder = Paths.get("src", "com", "epam", "javacore", "homework05", "task01", "testFolder");

        Path fileToDelete = Paths.get("C:\\andy\\development\\JavaTraining\\JavaCoreDec2018\\JavaCoreDec2018" +
                "\\src\\com\\epam\\javacore\\homework05\\task01\\testFolder\\folder\\folder1\\textFile3.txt");
        TextFile textFile3 = new TextFile(fileToDelete);

        FileManager fileManager = new FileManager(rootFolder);
        fileManager.findAllTextFiles();

        System.out.println("Before the file was deleted:");
        for (TextFile textFile : fileManager.textFiles){
            System.out.println(textFile.getPath().toString());
        }

        fileManager.deleteTextFile(textFile3);

        System.out.println("After the file was deleted:");
        for (TextFile textFile : fileManager.textFiles){
            System.out.println(textFile.getPath().toString());
        }
    }
}
