package Lab7;

import java.io.FileNotFoundException;
import java.util.TreeMap;
import java.util.TreeSet;

public interface IFileReader {
    public TreeMap<String, TreeSet<String>> readFileToTreeMap(String filePath) throws FileNotFoundException;
}
