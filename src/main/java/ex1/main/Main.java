package ex1.main;

import ex1.classes.DirectoryList;

import java.io.File;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        DirectoryList directoryList = new DirectoryList("..\\1.5-JavaUtils-N1");
        File file = new File("..\\1.5-JavaUtils-N1");
        directoryList.treeDirectoryPrint(file);
    }
}
