import java.io.File;
import java.text.SimpleDateFormat;

public class DirectoryList {
    private String directoryPath;

    public DirectoryList(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void treeDirectoryPrint() {
        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Directory does not exist or is not valid.");
            return;
        }
        System.out.println("(Root) " + directory.getName());
        treeDirectoryPrint(directory, "  ");
    }

    public void treeDirectoryPrint(File directoryToTree, String indent) {
        SimpleDateFormat readableFormat = new SimpleDateFormat("yyyy-MM-dd");
        File[] files = directoryToTree.listFiles();

        if (files == null || files.length == 0) {
            System.out.println(indent + "[Empty Directory]");
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println(indent + "├── (D) " + file.getName() + " [Last modified: " + readableFormat.format(file.lastModified()) + "]");
                treeDirectoryPrint(file, indent + "│   ");
            } else {
                System.out.println(indent + "├── (F) " + file.getName() + " [Last modified: " + readableFormat.format(file.lastModified()) + "]");
            }
        }
    }
}