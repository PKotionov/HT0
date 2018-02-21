package com.epam.tat.venyamin.HT0.Prj02;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Mp3Finder implements FileFinder {
    private final String EXTENSION = ".mp3";

    @Override
    public List<File> findFilesInDir(String path) {
        List<File> fileList = new ArrayList<>();
        File dir = new File(path);
        if (dir.exists()) {
            if (dir.isDirectory()) {
                File[] files = dir.listFiles();
                for (File file : files) {
                    if(file.isDirectory()){
                     fileList.addAll(findFilesInDir(file.getAbsolutePath()));
                    } else {
                        if (file.getAbsolutePath().endsWith(EXTENSION)) {
                            fileList.add(file);
                        }
                    }
                }
            } else {
                if (dir.getAbsolutePath().endsWith(EXTENSION)) {
                    fileList.add(dir);
                }
            }
        } else {
            System.out.println(path + " not found.");
        }
        return fileList;
    }
}
