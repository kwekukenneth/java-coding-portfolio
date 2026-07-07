import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class FileManagerTest {
    
    private FileManager fm;
    private String testFile = "test.txt";
    
    @BeforeEach
    void setup() {
        fm = new FileManager();
    }
    
    @AfterEach
    void cleanup() {
        new File(testFile).delete();
    }
    
    @Test
    void testWriteAndRead() throws IOException {
        // Write to file
        fm.writeFile(testFile, "Hello World");
        
        // Read from file
        String content = fm.readFile(testFile);
        
        // Verify
        assertEquals("Hello World", content);
        System.out.println("✓ Write and read test passed");
    }
    
    @Test
    void testOverwrite() throws IOException {
        fm.writeFile(testFile, "First");
        fm.writeFile(testFile, "Second");
        
        assertEquals("Second", fm.readFile(testFile));
        System.out.println("✓ Overwrite test passed");
    }
    
    @Test
    void testReadNonExistentFile() {
        assertThrows(IOException.class, () -> fm.readFile("missing.txt"));
        System.out.println("✓ Exception handling test passed");
    }
}