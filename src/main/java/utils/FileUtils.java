package utils;

import java.io.*;
import java.util.List;

/**
 * A class to read text files from resources.
 */
public class FileUtils {

    /**
     * Reads all lines from a file from resources.
     *
     * @param relativePath the file path inside resources
     * @return a list of lines
     * @throws IOException if the file cannot be read or is not found
     */
    public static List<String> readFileLines(String relativePath) throws IOException {
        InputStream is = FileUtils.class.getClassLoader().getResourceAsStream(relativePath);
        if (is == null) {
            throw new FileNotFoundException("File not found: " + relativePath);
        }
        return new BufferedReader(new InputStreamReader(is))
                .lines()
                .toList();
    }
}
