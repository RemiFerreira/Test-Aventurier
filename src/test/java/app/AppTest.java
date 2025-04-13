package app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.Test;
import java.io.PrintStream;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * Test the run function with an invalid map.
     */
    @Test
    public void testRun_InvalidMap() {
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        App.run("test/bad_char.txt", "test/valid.txt");

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Error with map file"));
    }

    /**
     * Test the run function with an invalid starting position.
     */
    @Test
    public void testRun_InvalidStartPosition() {
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        App.run("test/valid.txt", "test/not_integer_coordinates.txt");

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Error with starting position : "));
    }

    /**
     * Test the run function with a missing file.
     */
    @Test
    public void testRun_MissingFile() {
        ByteArrayOutputStream err = new ByteArrayOutputStream();
        System.setErr(new PrintStream(err));

        App.run("dontexist.txt", "dontexist.txt");

        String errorOutput = err.toString();
        assertTrue(errorOutput.contains("Error while reading file"));
    }

}
