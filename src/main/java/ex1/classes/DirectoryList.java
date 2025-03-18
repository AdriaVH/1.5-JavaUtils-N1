package ex1.classes;

import java.io.File;
import java.text.SimpleDateFormat;

public class DirectoryList {
    private String directoryPath;
    private File directoryFile;

    public DirectoryList(String directoryPath) {
        this.directoryPath = directoryPath;
        this.directoryFile = new File(directoryPath);
    }
    public File getDirectoryFile() {
        return directoryFile;
    }
    public void alphabeticalContentListing() {
        File[] files = directoryFile.listFiles();
        try {
            if (files == null) {
                new NullPointerException("Directory does not exist or cannot be accessed.");
            }
            for (File file : files) {
                System.out.println(file.getName());
            }
        } catch (NullPointerException e) {
            e.getMessage();
        }
    }

    public void treeDirectoryPrint(File directoryToTree, int level) {
        if (directoryToTree == null || !directoryToTree.exists()) {
            System.out.println("Directory does not exist or cannot be accessed.");
            return;
        }

        SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
        File[] files = directoryToTree.listFiles();
        if (files == null) {
            return; // Handle inaccessible or empty directories gracefully
        }

        for (File file : files) {
            // Create the appropriate level indentation
            String indent = "  ".repeat(level);

            if (file.isDirectory()) {
                System.out.println(indent + "(D) " + file.getName() + " Last modified -> " + readableFormat.format(file.lastModified()));
                treeDirectoryPrint(file, level + 1); // Increase level for subdirectory
            } else {
                System.out.println(indent + "(F) " + file.getName() + " Last modified -> " + readableFormat.format(file.lastModified()));
            }
        }
    }
}

