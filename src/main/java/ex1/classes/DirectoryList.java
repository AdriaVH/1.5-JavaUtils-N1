package ex1.classes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;


public class DirectoryList {
    private final String directoryPath;
    File file;

    public File getFile() {
        return file;
    }

    public DirectoryList(String directoryPath) {
        this.directoryPath = directoryPath;
        file = new File(directoryPath);
    }
    private void validateDirectory(File directory) {
        if (directory == null || !directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: Directory is null, does not exist, or is not accessible.");
        }
    }

    public void alphabeticalContentListing() {
        validateDirectory(file);
        File[] files = file.listFiles();
        Arrays.sort(files);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    public void treeDirectoryPrint(File directoryToTree, int level) {
        validateDirectory(directoryToTree);

        SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
        File[] files = directoryToTree.listFiles();
        String indent = "  ".repeat(level);

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(indent + "(D) " + file.getName() + " Last modified -> " + readableFormat.format(file.lastModified()));
                treeDirectoryPrint(file, level + 1); // Increase level for subdirectory
            } else {
                System.out.println(indent + "(F) " + file.getName() + " Last modified -> " + readableFormat.format(file.lastModified()));
            }
        }
    }

    public void treeDirectorySaveOnTxt(File directoryToTree, int level, BufferedWriter bufferedWriter) {
        validateDirectory(directoryToTree);

        SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
        File[] files = directoryToTree.listFiles();
        String lineToWrite;

        for (File file : files) {
            lineToWrite = "  ".repeat(level);

            if (file.isDirectory()) {
                lineToWrite += "(D) " + file.getName() + " Last modified -> "
                        + readableFormat.format(file.lastModified());
                writeOnTxt(lineToWrite, bufferedWriter);
                treeDirectorySaveOnTxt(file, level + 1, bufferedWriter);
            } else {
                lineToWrite += "(F) " + file.getName() + " Last modified -> "
                        + readableFormat.format(file.lastModified());
                writeOnTxt(lineToWrite, bufferedWriter);
            }
        }
    }

    public void writeOnTxt(String lineToWrite, BufferedWriter bufferedWriter) {
        try {
            bufferedWriter.write(lineToWrite);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("Error writing on txt file");
            e.printStackTrace();
        }

    }
}

