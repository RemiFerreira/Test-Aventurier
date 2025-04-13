package model;

/**
 * Represents an empty cell that can be traversed.
 */
public class EmptyCell extends Cell {
    /**
     * Always returns true for empty cells.
     */
    @Override
    public boolean isPassable() {
        return true;
    }
}