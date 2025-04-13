package app;

import java.util.List;
import java.io.IOException;
import model.*;
import exceptions.*;
import utils.InputHandler;

/**
 * The main application.
 */
public class App {

    /**
     * The entry point of the application.
     * Initialize map, player, and moves from files in resources.
     * Applies the moves to the player and print the final position.
     *
     * @param args command-line arguments: [0]: map, [1]: input
     */
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error with main arguments: " + args.length);
            return;
        }
        run(args[0], args[1]);
    }

    public static void run(String mapFile, String inputFile) {
        try {
            Map map = new Map(mapFile);

            List<Integer> startPosition = InputHandler.getStartPosition(inputFile);
            Player player = new Player(startPosition.get(0), startPosition.get(1));

            char[] moves = InputHandler.getAllMoves(inputFile);

            player.doMoves(moves,map);
            player.printPosition();
        }catch (IOException e) {
            System.err.println("Error while reading file : " + e.getMessage());
        }catch (InvalidMapException e){
            System.err.println("Error with map file : " + e.getMessage());
        } catch (InvalidStartPositionException e) {
            System.err.println("Error with starting position : " + e.getMessage());
        }
    }
}
