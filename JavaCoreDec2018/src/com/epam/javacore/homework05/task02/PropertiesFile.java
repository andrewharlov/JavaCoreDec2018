package com.epam.javacore.homework05.task02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Properties;

public class PropertiesFile {
    private Path path;
    private Properties properties = new Properties();

    public PropertiesFile(Path path){
        this.path = path;
    }

    public void readPropertiesFile() throws IOException{
        File file = new File(path.toUri());
        InputStream inputStream;
        inputStream = new FileInputStream(file);
        properties.load(inputStream);
        inputStream.close();
    }

    public String getProperty(String key) throws PropertiesKeyNotFoundException{
        String property = properties.getProperty(key);
        if (property == null){
            throw new PropertiesKeyNotFoundException("The property '" + key + "' was not found.");
        }
        return property;
    }
}
