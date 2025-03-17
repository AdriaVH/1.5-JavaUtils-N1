package ex1.main;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String directoryPath = args[0];
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        Arrays.stream(files).sorted();

    }
}