package utils;
import exceptions.InvalidStartPositionException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A class for handling input files.
 */
public class InputHandler {

    /**
     * Read the start position from the file (eg 3,1)
     *
     * @param file the file inside resources/input
     * @return a list of two integers
     * @throws IOException if the file cannot be read or is not found
     * @throws InvalidStartPositionException if the start position is not valid
     */
    public static List<Integer> getStartPosition(String file) throws IOException {
        List<String> lines = FileUtils.readFileLines("input/" + file);
        String[] position = lines.get(0).split(",");
        if (position.length != 2) {
            throw new InvalidStartPositionException("Expected 2 values but got " + position.length);
        }
        try {
            return Arrays.stream(position)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new InvalidStartPositionException("Start position is not integers: " + lines.get(0));
        }
    }

    /**
     * Reads the movement the file (must be in second line)
     *
     * @param file the file inside resources/input
     * @return a char array representing the moves
     * @throws IOException if the file cannot be read or is not found
     */
    public static char[] getAllMoves(String file) throws IOException {
        List<String> lines = FileUtils.readFileLines("input/" + file);
        String moves = lines.get(1);
        return moves.toCharArray();
    }
}