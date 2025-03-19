package ex1.main;

import ex1.classes.DirectoryList;

import java.io.*;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Error: No directory path provided. Please add the directory path as the first command-line argument.");
            return; // Exit the program
        }
        String inputPath = Paths.get(args[0]).toAbsolutePath().toString();

        DirectoryList directoryList = new DirectoryList(inputPath);
        FileWriter outputFile = new FileWriter("output.txt", true);
        BufferedWriter bufferedWriter = new BufferedWriter(outputFile);

        System.out.println("Ex 1");
        directoryList.alphabeticalContentListing();

        System.out.println("Ex 2");
        directoryList.treeDirectoryPrint(directoryList.getFile(), 0);

        System.out.println("Ex 3");
        directoryList.treeDirectorySaveOnTxt(directoryList.getFile(), 0, bufferedWriter);
        bufferedWriter.close();
        System.out.println("Open output.txt to see the result");

        Scanner inputFile = new Scanner(directoryList.getFile());
        while (inputFile.hasNextLine()) {
            System.out.println(inputFile.nextLine());
        }
        inputFile.close();

    }
}