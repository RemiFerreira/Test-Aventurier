package model;
import exceptions.InvalidMapException;
import java.io.IOException;
import java.util.List;
import utils.FileUtils;

/**
 * Represents a map
 */
public class Map {

    /**
     * Represents a grid of Cell
     */
    private Cell[][] map;

    /**
     * Constructs a new Map by loading its content.
     *
     * @param file the name of the map file located in the "maps" folder
     * @throws IOException if the file cannot be read
     * @throws InvalidMapException if the file contains unknown characters
     */
    public Map(String file) throws IOException, InvalidMapException {
        loadMap(file);
    }

    /**
     * Loads the map from a file.
     *
     * @param file the name of the map file located in the "maps" folder
     * @throws IOException if the file cannot be read
     * @throws InvalidMapException if the file contains unknown characters
     */
    private void loadMap(String file) throws IOException, InvalidMapException {
        List<String> lines = FileUtils.readFileLines("maps/" + file);

        int rows = lines.size();
        int cols = lines.get(0).length();
        map = new Cell[rows][cols];

        for (int y = 0; y < rows; y++) {
            String line = lines.get(y);
            for (int x = 0; x < cols; x++) {
                char c = line.charAt(x);
                switch (c) {
                    case '#' :
                        map[y][x] = new WoodCell();
                        break;
                    case ' ' :
                        map[y][x] = new EmptyCell();
                        break;
                    default :
                        throw new InvalidMapException("Unrecognized character: " + c);
                }
            }
        }
    }

    /**
     * Check if a given position is inside the bounds of the map.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return true if the coordinates are in the map bounds, false if not
     */
    public boolean isInMap(int x, int y) {
        return y >= 0 && y < map.length && x >= 0 && x < map[0].length;
    }

    /**
     * Check if the cell at the given position is in the map and is passable.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return true if the cell is inside the map and can be traversed, false if not
     */
    public boolean isPassable(int x, int y) {
        return isInMap(x, y) && map[y][x].isPassable();
    }
}
