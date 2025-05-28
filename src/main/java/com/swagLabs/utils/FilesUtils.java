package com.swagLabs.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FilesUtils {
    private FilesUtils() {
        // Prevent instantiation
    }

    public static File getLatestFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] filesList = dir.listFiles();
        if (filesList == null || filesList.length == 0) {
            LogsUtil.warn("No files found in directory: " + dirPath);
            return null;
        }
        File latestFile = filesList[0];
        for (File file : filesList) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }
        return latestFile;
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
                    LogsUtil.error("Failed to delete file: " + file + " - " + e.getMessage());
                }
            }
        }
        // Attempt to delete the directory itself after its contents are deleted
        try {
            Files.delete(dirPath.toPath());
        } catch (IOException e) {
            // It's fine if the root directory is not deleted (e.g., test-outputs/Logs)
            LogsUtil.warn("Could not delete directory: " + dirPath + " - " + e.getMessage());
        }
    }

    public static void copyFile(File source, File destination) {
        if (source == null || !source.exists()) {
            LogsUtil.warn("Source file does not exist: " + source);
            return;
        }
        try {
            Files.copy(source.toPath(), destination.toPath());
            LogsUtil.info("Copied file from " + source + " to " + destination);
        } catch (IOException e) {
            LogsUtil.error("Failed to copy file: " + e.getMessage());
        }
    }
}