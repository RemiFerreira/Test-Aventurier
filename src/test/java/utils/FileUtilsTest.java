package utils;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for FileUtils.
 */
public class FileUtilsTest {

    /**
     * Test if a file can be read
     */
    @Test
    public void testReadFileLines_valid() throws IOException {
        List<String> lines = FileUtils.readFileLines("input/test/valid.txt");
        assertNotNull(lines);
        assertFalse(lines.isEmpty());
    }

    /**
     * Test if an unfounded file throw an error
     */
    @Test
    public void testReadFileLines_notFound() {
        assertThrows(IOException.class, () -> {
            FileUtils.readFileLines("input/test/dontexist.txt");
        });
    }
}
