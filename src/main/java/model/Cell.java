package model;

/**
 * Abstract class for a cell.
 */
public abstract class Cell {
    /**
     * Tells if the cell can be traversed.
     *
     * @return true if the cell is passable, false if not
     */
    public abstract boolean isPassable();
}