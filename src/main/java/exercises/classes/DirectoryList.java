package exercises.classes;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;


public class DirectoryList implements Serializable {

    private final File DIRECTORY;

    public DirectoryList(File directory) {
        this.DIRECTORY = directory;
    }

    private void validateDirectory(File directory) {
        if (directory == null || !directory.exists() || !directory.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: Directory is null, does not exist, or is not accessible.");
        }
    }

    public void alphabeticalContentListing(File directoryToSort) {
        validateDirectory(directoryToSort);
        File[] files = directoryToSort.listFiles();
        Arrays.sort(files);
    }

    public void treeDirectoryPrint(File directoryToTree, int level) {
        validateDirectory(directoryToTree);

        SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
        File[] files = directoryToTree.listFiles();
        String toPrint;

        for (File file : files) {
            toPrint = file.getName() + "\tLAST MODIFIED -> " + readableFormat.format(file.lastModified());

            if (file.isDirectory()) {
                toPrint = "  ".repeat(level) + "(D) " + toPrint;
                alphabeticalContentListing(file);
                System.out.println(toPrint);
                treeDirectoryPrint(file, level + 1); // Increase level for subdirectory
            } else {
                toPrint = "  ".repeat(level) + "(F) " + toPrint;
                System.out.println(toPrint);
            }
        }
    }
    public void treeDirectorySaveOnTxt(File directoryToTree, int level) throws IOException {
        validateDirectory(directoryToTree);
        FileWriter outputFile = new FileWriter("output.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(outputFile);

        SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
        File[] files = directoryToTree.listFiles();
        String toPrint;

        for (File file : files) {
            toPrint = file.getName() + " Last modified -> " + readableFormat.format(file.lastModified());

            if (file.isDirectory()) {
                toPrint = "  ".repeat(level) + "(D)  " + toPrint;
                alphabeticalContentListing(file);
                writeOnTxt(toPrint, bufferedWriter);
                treeDirectorySaveOnTxt(file, level + 1);
            } else {
                toPrint = "  ".repeat(level) + "(F)  " + toPrint;
                writeOnTxt(toPrint, bufferedWriter);
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

    public void printTxtOnConsole (File toPrint) throws FileNotFoundException {
        if (toPrint.isFile()) {
            Scanner inputFile = new Scanner(toPrint);
            while (inputFile.hasNextLine()) {
                System.out.println(inputFile.nextLine());
            }
            inputFile.close();
        } else {
            throw new FileNotFoundException("This is not a file");
        }
    }
    public void serialize (String fileSer){
        try (FileOutputStream outFileDirectoryList = new FileOutputStream(fileSer);
             ObjectOutputStream outObjectDirectoryList = new ObjectOutputStream(outFileDirectoryList);
        ) {
            outObjectDirectoryList.writeObject(DIRECTORY);
            System.out.println("Object serialised");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public DirectoryList desirialize (String fileSer) {
        DirectoryList serialisedDirectoryList = null;

        try (FileInputStream fileIn = new FileInputStream(fileSer);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            serialisedDirectoryList = (DirectoryList) in.readObject();
            System.out.println("Objecte deserialised");
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return serialisedDirectoryList;
    }

    @Override
    public String toString() {
        return "DirectoryList{" +
                "directory=" + DIRECTORY +
                '}';
    }
}

