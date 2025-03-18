package ex1.main;

import ex1.classes.DirectoryList;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DirectoryList directoryList = new DirectoryList("..\\1.5-JavaUtils-N1");

        System.out.println("Alphabetical Listing:");
        directoryList.alphabeticalContentListing();

        System.out.println("\nTree Structure:");
        directoryList.treeDirectoryPrint(directoryList.getDirectoryFile(), 0);
    }
}