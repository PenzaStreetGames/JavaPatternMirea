package com.penzastreetstudios.task12;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;
import java.nio.file.Path;

@Component
public class FileCheck {

    @PostConstruct
    public void hashFile() {
        System.out.println("postConstruct");
        String pathSourceFile = Task12Application.pathSourceFile;
        String pathHashFile = Task12Application.pathHashFile;
        File sourceFile = new File(pathSourceFile);
        try {
            String data = readSourceFile();
            System.out.println("Source file found");
            String hash = String.valueOf(data.hashCode());
            writeToHashFile(hash);
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found");
            writeToHashFile("null");
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @PreDestroy
    public void removeFile() {
        System.out.println("preDestroy");
        String sourceFile = Task12Application.pathSourceFile;
        new File(sourceFile).delete();
    }

    public void writeToHashFile(String data) {
        String pathHashFile = Task12Application.pathHashFile;
        File hashFile = new File(pathHashFile);
        try {
            FileWriter fileWriter = new FileWriter(pathHashFile);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String readSourceFile() throws IOException {
        String sourceFile = Task12Application.pathSourceFile;
        FileReader fileReader = new FileReader(sourceFile);
        StringBuilder sb = new StringBuilder();
        int c;
        while ((c = fileReader.read()) != -1) {
            sb.append((char) c);
        }
        fileReader.close();
        return sb.toString();
    }
}
