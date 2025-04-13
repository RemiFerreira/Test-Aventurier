package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for EmptyCell.
 */
public class EmptyCellTest {

    /**
     * Check if an empty cell is passable
     */
    @Test
    public void testIsPassable() {
        EmptyCell emptyCell = new EmptyCell();
        assertTrue(emptyCell.isPassable());
    }
}