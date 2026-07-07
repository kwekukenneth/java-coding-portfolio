import java.io.*;
import java.nio.file.*;

/**
 * Simple FileManager for reading and writing text files.
 */
public class FileManager {
    
    public void writeFile(String path, String content) throws IOException {
        Files.writeString(Paths.get(path), content);
    }
    
    public String readFile(String path) throws IOException {
        return Files.readString(Paths.get(path));
    }
}