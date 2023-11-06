package Lab7;

/**
 * myFileReader
 * @author Ben Sweeney
 * @version 20231106

 */

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.io.IOException;
import java.io.*;

public class myFileReader implements IFileReader {

    /**
     * Takes in the filepath to a CSV, reads it to a TreeMap
     * Key = Country name
     * Value = remaining columns
     *
     * @param filePath filename for the desired CSV
     * @return null
     */
    //@Override
    public TreeMap<String, TreeSet<String>> readFileToTreeMap(String filePath) throws FileNotFoundException {
        FileInputStream fileInStream = new FileInputStream(filePath); // File input stream
        Scanner inFile = new Scanner(fileInStream);
       // inFile.useDelimiter("[,\r\n]+");

        TreeMap<String, TreeSet<String>> newTree = new TreeMap<>();
        TreeSet<String> tempSet = new TreeSet<>();
        while (inFile.hasNext()) {
            newTree.put(inFile.next(), null);
            tempSet.add(inFile.next());

        }

        return newTree;
    }
//    public static void readFile(String filePath) {
//        readFileToTreeMap(filePath);
//    }
}
