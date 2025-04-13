package model;

import exceptions.InvalidMapException;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test class for Map.
 */
public class MapTest {
    /**
     * Test loading with a valid file.
     */
    @Test
    public void testLoadMap_valid() throws IOException, InvalidMapException {
        Map map = new Map("test/valid.txt");
        assertTrue(map.isPassable(1, 1));
        assertFalse(map.isPassable(2, 0));
    }

    /**
     * Test loading with a bad char file.
     */
    @Test
    public void testLoadMap_badChar() throws IOException, InvalidMapException {
        assertThrows(InvalidMapException.class, () -> {
            new Map("test/bad_char.txt");
        });
    }

    /**
     * Test isInMap with valid.txt file (3 by 3).
     */
    @Test
    public void testIsInMap() throws IOException, InvalidMapException {
        Map map = new Map("test/valid.txt");
        assertTrue(map.isInMap(0, 0));
        assertFalse(map.isInMap(-1, -1));
        assertFalse(map.isInMap(4, 4));
        assertFalse(map.isInMap(-1, 0));
    }

    /**
     * Test isPassable with valid.txt file (3 by 3).
     */
    @Test
    public void testIsPassable() throws IOException, InvalidMapException {
        Map map = new Map("test/valid.txt");
        assertTrue(map.isPassable(0, 0));
        assertFalse(map.isPassable(-1, 0));
        assertFalse(map.isPassable(0, -1));
        assertFalse(map.isPassable(2, 0));
    }
}
