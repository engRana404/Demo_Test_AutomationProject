package com.swagLabs.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FilesUtils {
    private FilesUtils() {
        // Prevent instantiation
    }

    /**
     * Returns the most recently modified file in the given directory.
     */
    public static File getLatestFileFromDir(String dirPath) {
        File dir = new File(dirPath);
        File[] filesList = dir.listFiles(File::isFile); // Exclude directories

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

    /**
     * Recursively deletes all files and subdirectories in the given directory.
     */
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

        // Attempt to delete the directory itself
        try {
            Files.delete(dirPath.toPath());
        } catch (IOException e) {
            LogsUtil.warn("Could not delete directory: " + dirPath + " - " + e.getMessage());
        }
    }

    /**
     * Copies a file from source to destination. Overwrites if destination exists.
     */
    public static void copyFile(File source, File destination) {
        if (source == null || !source.exists()) {
            LogsUtil.warn("Source file does not exist: " + source);
            return;
        }

        try {
            Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
            LogsUtil.info("Copied file from " + source + " to " + destination);
        } catch (IOException e) {
            LogsUtil.error("Failed to copy file from " + source + " to " + destination + " - " + e.getMessage());
        }
    }

    /**
     * Cleans all contents of the given directory without deleting the directory itself.
     */
    public static void cleanDirectory(File dir) {
        if (dir == null || !dir.exists() || !dir.isDirectory()) {
            LogsUtil.warn("Invalid directory: " + dir);
            return;
        }

        try {
            FileUtils.cleanDirectory(dir);
            LogsUtil.info("Cleaned directory: " + dir);
        } catch (IOException e) {
            LogsUtil.error("Failed to clean directory: " + dir + " - " + e.getMessage());
        }
    }
}
