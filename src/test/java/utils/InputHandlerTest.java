package utils;

import exceptions.InvalidStartPositionException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.List;

/**
 * Test class for InputHandler.
 */
public class InputHandlerTest {

    /**
     * Test a valid start file.
     */
    @Test
    public void testGetStartPosition_valid() throws IOException {
        List<Integer> startPosition = InputHandler.getStartPosition("test/valid.txt");
        assertNotNull(startPosition);
        assertEquals(2, startPosition.size());
        assertEquals(0, startPosition.get(0));
        assertEquals(0, startPosition.get(1));
    }

    /**
     * Test a file with more or less than 2 coordinates
     */
    @Test
    public void testGetStartPosition_notTwoCoordinates() {
        assertThrows(InvalidStartPositionException.class, () -> {
            InputHandler.getStartPosition("test/not_two_coordinates.txt");
        });
    }

    /**
     * Test with non integer coordinates.
     */
    @Test
    public void testGetStartPosition_notInteger() {
        assertThrows(InvalidStartPositionException.class, () -> {
            InputHandler.getStartPosition("test/not_integer_coordinates.txt");
        });
    }

    /**
     * Test a valid moves files.
     */
    @Test
    public void testGetAllMoves_valid() throws IOException {
        char[] moves = InputHandler.getAllMoves("test/valid.txt");
        assertNotNull(moves);
        assertEquals(4, moves.length);
        assertEquals('S', moves[0]);
        assertEquals('N', moves[1]);
        assertEquals('E', moves[2]);
        assertEquals('O', moves[3]);
    }
}
