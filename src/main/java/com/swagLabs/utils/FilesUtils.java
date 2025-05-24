package com.swagLabs.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils() {
        // Prevent instantiation
        super();
    }

    public static void deleteFiles(File dirPath) {
        if (dirPath == null || !dirPath.exists()) {
            LogsUtil.warn("Directory does not exist: " + dirPath);
            return;
        }
        File[] filesList = dirPath.listFiles();
        if (filesList == null) {
            LogsUtil.warn("Failed to list files in: " + dirPath);
            return;
        }
        for (File file : filesList) {
            if (file.isDirectory()) {
                deleteFiles(file);
            } else {
                try {
                    Files.delete(file.toPath());
                } catch (IOException e) {
                    LogsUtil.error("Failed to delete file: " + file);
                }
            }
        }
    }
}
