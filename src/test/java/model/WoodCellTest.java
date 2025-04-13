package model;

import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Test class for WoodCell.
 */
public class WoodCellTest {
    /**
     * Check if a wood cell is not passable
     */
    @Test
    public void testIsPassable() {
        WoodCell woodCell = new WoodCell();
        assertFalse(woodCell.isPassable());
    }
}
