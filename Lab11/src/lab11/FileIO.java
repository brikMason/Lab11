package lab11;

import java.io.IOException;
import java.io.File;


public class FileIO {

    public static void main(String[] args) throws IOException {

        // SPEED operations...

        System.out.println("SPEED operations... \n");

        // Find the specified files
        System.out.println("Found these text files: \n");

        File SPEED = new File("/Users/wesmaxwell/Desktop/Backup/SPEED");
        File[] listOfFiles = SPEED.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith("txt")) {
                System.out.println("File " + i + ": " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isFile()) {
                continue;
            }
        }

        // Delete the specified files.
        System.out.println();
        System.out.println("Deleted these files due to irrelevancy: \n");

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile() && listOfFiles[i].getName().endsWith("txt")) {
                continue;
            } else if (listOfFiles[i].isFile()) {
                listOfFiles[i].delete();
                System.out.println("\"" + listOfFiles[i].getName() + "\"" + " was irrelevant and therefore deleted.");
            }
        }


        // APOLLO operations...
        System.out.println();
        System.out.println("************************************************************");
        System.out.println();
        System.out.println("APOLLO operations...\n");

        File APOLLO = new File("/Users/wesmaxwell/Desktop/Backup/APOLLO");
        File[] listOfFiles2 = APOLLO.listFiles();


        /*
            This section gets the first file in the directory,
            and removes the extension from the name.
         */
        String findTotal = listOfFiles2[0].getName();
        String[] parts = findTotal.split("\\.", 2);
        String name = parts[0];

        /*
            This section estimates the number of expected files
            by taking the last character of the file name and
            assuming it is a number. This code would only work
            for this lab, and if the last character of the file
            name is a number. Assumes file name ends in "*of*.extension".
         */

        char c = name.charAt(name.length() - 1);
        int expectedNumberOfFiles = Character.getNumericValue(c);
        int totalFiles = APOLLO.listFiles().length;

        // Prints message regarding found/expected files.

        System.out.println("Expected total files: " + expectedNumberOfFiles);
        System.out.println("Number of files found: " + totalFiles);

        if (totalFiles < expectedNumberOfFiles){
            System.out.println("Received less than expected! Files are missing!");
        } else if (totalFiles > expectedNumberOfFiles){
            System.out.println("Received more than expected! Possible duplicates!");
        } else {
            System.out.println("All files accounted for!");
        }

    }

}