package com.hyberlet.task_23.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
@ManagedResource
public class SchedulerService {
    private final String BACKUP_DIR = "src/main/resources/backups";

    @Autowired
    private StudentService studentService;
    @Autowired
    private UniversityService universityService;

    @Async
    @Scheduled(cron = "0 0/30 * * * *")
    @ManagedOperation
    public void doBackup() {
        log.info("deleting early backup files");
        File backupDir = new File(BACKUP_DIR);
        deleteDir(backupDir, true);
        log.info("early backup files deleted");

        log.info("writing entities");
        log.info("writing students");
        List<String> studentStrings = studentService.getStudents().stream().map(Object::toString).toList();
        writeEntity(BACKUP_DIR + "/" + "students.txt", studentStrings);
        log.info("students written");
        log.info("writing universities");
        List<String> universityStrings = universityService.getUniversities().stream().map(Objects::toString).toList();
        writeEntity(BACKUP_DIR + "/" + "universities.txt", universityStrings);
        log.info("universities written");
        log.info("entities written");
    }

    private void deleteDir(File dir, boolean root) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files)
                deleteDir(file, false);
        }
        if (!root)
            dir.delete();
    }

    private void writeEntity(String filename, List<String> objects) {
        try {
            FileWriter fileWriter = new FileWriter(filename);
            for (String object : objects) {
                fileWriter.write(object);
                fileWriter.write("\n");
            }
            fileWriter.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
