package ex1.main;

import ex1.classes.DirectoryList;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File directoryToSort = new File("..\\1.5-Javautils-N1\\src\\main");

        DirectoryList directoryList = new DirectoryList();



        System.out.println("\nEx 1");
        directoryList.alphabeticalContentListing(directoryToSort);

        System.out.println("\nEx 2");
        directoryList.treeDirectoryPrint(directoryToSort, 0);

        System.out.println("\nEx 3");
        directoryList.treeDirectorySaveOnTxt(directoryToSort, 0);
        System.out.println("Open output.txt to see the result");

        System.out.println("\nEx 4");
        File toScan = new File("..\\1.5-JavaUtils-N1\\src\\main\\java\\readme.txt");
        directoryList.printTxtOnConsole(toScan);



    }
}