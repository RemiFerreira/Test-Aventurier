package model;

/**
 * Represents a player moving across a map.
 */
public class Player{

    /**
     * Represents the x and y-coordinate of the player.
     */
    private int x,y ;

    /**
     * Set a start position for the player.
     *
     * @param startX The x-coordinate of the starting position
     * @param startY The y-coordinate of the starting position
     */
    public Player (int startX, int startY){
        x = startX;
        y = startY;
    }

    /**
     * Return the x-coordinate for the player.
     *
     * @return the x-coordinate
     */
    public int getX(){
        return x;
    }

    /**
     * Return the y-coordinate for the player.
     *
     * @return the y-coordinate
     */
    public int getY(){
        return y;
    }

    /**
     * Print the player's position.
     */
    public void printPosition(){
        System.out.println("Le personnage se trouve en ("+x+","+y+")");
    }

    /**
     * Executes a move in the given direction, if the destination cell is passable.
     *
     * @param direction the direction: 'N' (North), 'S' (South), 'E' (East), or 'O' (West)
     * @param map the map used to check if the next cell is passable
     */
    public void doMove (char direction, Map map){
        int nextX = x;
        int nextY = y;
        switch (direction){
            case 'N':
                nextY--;
                break;
            case 'S':
                nextY++;
                break;
            case 'E':
                nextX++;
                break;
            case 'O':
                nextX--;
                break;
            default:
                break;
        }
        if(map.isPassable(nextX, nextY)){
            x=nextX;
            y=nextY;
        }
    }

    /**
     * Executes a sequence of moves on the map.
     *
     * @param moves an array of directions (e.g., {'N', 'E', 'S'})
     * @param map the map used for each move
     */
    public void doMoves (char[] moves, Map map){
        for(char m : moves){
            this.doMove(m, map);
        }
    }
}