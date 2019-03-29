package com.epam.javacore.homework05.task01;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileManager {
    private List<TextFile> textFiles = new ArrayList<>();
    private Path rootFolder;

    public FileManager(Path rootFolder){
        this.rootFolder = rootFolder;
    }

    public void findAllTextFiles(){
        textFiles.clear();
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

        File[] folderItems = folder.listFiles();

        if (folderItems != null){
            for (File fileEntry : folderItems) {
                if (fileEntry.isDirectory()) {
                    listFilesForFolder(fileEntry, textFilter);
                } else if (!filteredFiles){
                    File[] txtFiles = folder.listFiles(textFilter);
                    if (txtFiles != null){
                        for (File entry : txtFiles) {
                            Path path = Paths.get(entry.getAbsolutePath());
                            textFiles.add(new TextFile(path));
                        }
                    }
                    filteredFiles = true;
                }
            }
        }
    }

    public void deleteTextFile(TextFile fileToDelete){
        boolean result = false;

        try {
            result = Files.deleteIfExists(fileToDelete.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (result){
            Iterator<TextFile> iterator = textFiles.iterator();
            while (iterator.hasNext()){
                TextFile textFile = iterator.next();
                if (fileToDelete.equals(textFile)){
                    iterator.remove();
                }
            }
        }
    }

    public TextFile createTextFile(Path folder, String fileName, String fileExtension){
        boolean isFileCreated = false;
        Path createdFilePath = null;

        try {
            File directory = new File(folder.toUri());
            File file = new File(directory, fileName + fileExtension);
            isFileCreated = file.createNewFile();
            createdFilePath = file.toPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextFile createdFile = null;
        if (isFileCreated && createdFilePath != null){
            createdFile = new TextFile(createdFilePath);
            return createdFile;
        } else {
            return createdFile;
        }
    }

    public List<TextFile> getTextFiles() {
        return textFiles;
    }
}
