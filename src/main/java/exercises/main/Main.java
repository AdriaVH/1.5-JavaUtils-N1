package exercises.main;

import exercises.classes.DirectoryList;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String directory;
        if(args.length < 1){
            directory = ".."+File.separator+"1.5-JavaUtils-N1"+File.separator+"src"+File.separator+"main";
        } else {
            directory = args[0];
        }
        File directoryToSort = new File(directory);
        DirectoryList directoryList = new DirectoryList(directoryToSort);

        System.out.println("\nEx 1");
        directoryList.alphabeticalContentListing(directoryToSort);

        System.out.println("\nEx 2");
        directoryList.treeDirectoryPrint(directoryToSort, 0);

        System.out.println("\nEx 3");
        directoryList.treeDirectorySaveOnTxt(directoryToSort, 0);
        System.out.println("Open output.txt to see the result");

        System.out.println("\nEx 4");
        File toScan = new File(".."+File.separator+"1.5-JavaUtils-N1"+File.separator+"src"+File.separator+"main"
                                        +File.separator+"java"+File.separator+"readme.txt");
        directoryList.printTxtOnConsole(toScan);

        System.out.println("\nEx 5");
        DirectoryList desirializeDirectoryList;
        directoryList.serialize("directoryList.ser");
        desirializeDirectoryList = directoryList.desirialize("directoryList.ser");

    }
}