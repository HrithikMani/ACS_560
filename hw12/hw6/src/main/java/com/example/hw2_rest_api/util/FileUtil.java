package com.example.hw2_rest_api.util;

import java.io.*;

public class FileUtil {

    /**
     * Copies a file from the resources folder to a writable directory.
     * 
     * @param resourceFilePath The path inside the resources folder.
     * @param targetFilePath The path where the file should be copied.
     * @throws IOException If any I/O error occurs.
     */
    public static void copyFileFromResources(String resourceFilePath, String targetFilePath) throws IOException {
        // Step 1: Ensure the target directory exists
        File targetFile = new File(targetFilePath);
        File directory = targetFile.getParentFile();  // Get the directory path

        // Create the directory if it does not exist
        if (directory != null && !directory.exists()) {
            boolean dirCreated = directory.mkdirs();  // Create the necessary parent directories
            if (!dirCreated) {
                throw new IOException("Failed to create directory: " + directory.getAbsolutePath());
            }
        }

        // If the target file already exists, do not copy
        if (targetFile.exists()) {
            System.out.println("File already exists: " + targetFilePath);
            return;  // File already exists, no need to copy
        }

        // Step 2: Copy the file from resources to the target directory
        try (InputStream inputStream = FileUtil.class.getResourceAsStream(resourceFilePath);
             OutputStream outputStream = new FileOutputStream(targetFilePath)) {

            if (inputStream == null) {
                throw new FileNotFoundException("Resource file not found: " + resourceFilePath);
            }

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully to: " + targetFilePath);
        }
    }
}
