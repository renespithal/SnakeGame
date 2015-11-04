package utils;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by andii on 04.11.2015.
 */
public class FileUtils {

    public static String readFile(String filename) {
        String result = "{}";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
        }
        return result;
    }
}
