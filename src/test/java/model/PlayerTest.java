package model;

import exceptions.InvalidMapException;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Fake map for testing.
 */
class FakeMap extends Map {
    public FakeMap() throws IOException, InvalidMapException {
        super("test/valid.txt");
    }

    @Override
    public boolean isPassable(int x, int y) {
        return !(x == -1 && y == -1);
    }
}

/**
 * Test class for Player.
 */
public class PlayerTest {

    FakeMap fakeMap = new FakeMap();

    public PlayerTest() throws IOException, InvalidMapException {
    }

    /**
     * Test the getters.
     */
    @Test
    public void testGetter() {
        Player player = new Player(0,0);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    /**
     * Test a move with N for direction
     */
    @Test
    public void testDoMove_N() {
        Player player = new Player(0,0);
        player.doMove('N',fakeMap);
        assertEquals(-1, player.getY());
    }

    /**
     * Test a move with S for direction
     */
    @Test
    public void testDoMove_S() {
        Player player = new Player(0,0);
        player.doMove('S',fakeMap);
        assertEquals(1, player.getY());
    }

    /**
     * Test a move with E for direction
     */
    @Test
    public void testDoMove_E() {
        Player player = new Player(0,0);
        player.doMove('E',fakeMap);
        assertEquals(1, player.getX());
    }

    /**
     * Test a move with O for direction
     */
    @Test
    public void testDoMove_O() {
        Player player = new Player(0,0);
        player.doMove('O',fakeMap);
        assertEquals(-1, player.getX());
    }

    /**
     * Test a move with bad direction
     */
    @Test
    public void testDoMove_badDirection() {
        Player player = new Player(0,0);
        player.doMove('A',fakeMap);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

    /**
     * Test a move with a cell not passable (in -1, -1)
     */
    @Test
    public void testDoMove_notPassable() {
        Player player = new Player(-1,0);
        player.doMove('N',fakeMap);
        assertEquals(-1, player.getX());
        assertEquals(0, player.getY());
    }

    /**
     * Test a list of move.
     */
    @Test
    public void testDoMoves() {
        Player player = new Player(0,0);
        char[] moves = {'E', 'S', 'O', 'N'};
        player.doMoves(moves, fakeMap);
        assertEquals(0, player.getX());
        assertEquals(0, player.getY());
    }

}
