package model;

/**
 * Represents a wood cell that cannot be traversed.
 */
public class WoodCell extends Cell {
    /**
     * Always returns false for wood cells.
     */
    @Override
    public boolean isPassable() {
        return false;
    }
}