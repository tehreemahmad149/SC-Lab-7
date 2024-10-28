package twitter;

import java.io.File;

public class FileSearcher {

    public static void main(String[] args) {

        String directoryPath = args[0];
        String fileName = args[1];
        
        File directory = new File(directoryPath);//passed in main
        
        // Check if the directory exists(test case)
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("name of directory does not exist");//added for debugginh
            return;
        }
        
        // search function recursive call
        boolean found = searchFile(directory, fileName);
        
        // file does not exist message
        if (!found) {
            System.out.println("File not found: " + fileName);
        }
    }

    public static boolean searchFile(File directory, String fileName) {
        // List all files and subdirectories in the current directory
        File[] files = directory.listFiles();//get all the file sin the directory and then match names
        
        if (files == null) {
            return false; // empty directory
        }
        
        for (File file : files) {
            // match file names
            if (file.isFile() && file.getName().equals(fileName)) {
                System.out.println("File found: " + file.getAbsolutePath());//check in console to see if it works...done
                return true;
            } else if (file.isDirectory()) {
                // file is not in root then call function to search in sub directory like a tree search algorithm
                if (searchFile(file, fileName)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}
