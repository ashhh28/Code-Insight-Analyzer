package reader;

import java.io.*;
import java.util.*;

public class FileReaderUtil {

    // Reads a file and returns all lines as a List
    public static List<String> readFile(String filePath) {

        List<String> lines = new ArrayList<>();

        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

            br.close();

        } catch (FileNotFoundException e) {
            System.out.println("❌ File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }

        return lines;
    }
}