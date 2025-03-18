package ex1.classes;

import java.io.File;
import java.text.SimpleDateFormat;

public class DirectoryList {
    private String directoryPath;
    File directory;
    private static String levelOfDepth = "  ";

        public DirectoryList (String directoryPath){
            this.directoryPath = directoryPath;
            directory = new File(directoryPath);

        }
        public void alphabeticalContentListing(){
            File[] files = directory.listFiles();
            for(File file :files) {
                System.out.println(file.getName());}
        }
        public void treeDirectoryPrint (File directoryToTree) {
            SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
            File[] files = directoryToTree.listFiles();

            for(File file : files) {

                if (file.isDirectory()){
                    System.out.println(levelOfDepth + "(D) " + file.getName() + "" + " Last modified -> " +  readableFormat.format(file.lastModified()));
                    levelOfDepth += "  ";
                    treeDirectoryPrint(file);
                } else {
                    System.out.println("  (F) " + file.getName() +  " Last modified -> " +  readableFormat.format(file.lastModified()));
                }
            }
        }
}

