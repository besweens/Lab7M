import java.io.IOException;
import java.io.*;
import java.util.*;
import Lab7.*;
public class Lab7Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Test");

        TreeMap<String, TreeSet<String>> testMap = new TreeMap<>();
       testMap =  myFileReader.readFileToTreeMap(args[0]);

    }
}
