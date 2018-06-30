package cs3331;
/**
 * Contains the model for the Connect Five board. (No GUI elements should placed here.)
 *
 * @author Edgar Padilla
 *
 */
public class Board
{
    Square[][] tiles;
    boolean[][] isFilled;
    private int counter=0;

    /** Defines the size of the board */
    public final int size;
    /**
     * Constructor including size of board
     * @param size Board Size
     */
    public Board(int size)
    {
        this.size = size;
        // Your Code Goes Here!
    }
    /**
     * Adds a disc to the game board.
     *
     * @param x x coordinate of where the disc needs to be placed.
     * @param y y coordinate of where the disc needs to be placed.
     */
    public void addDisc(int x, int y)
    {
        // Your Code Goes Here!
    }
    /**
     * Checks if input positions is valid. Checks if valid x-y range. Also checks if position is empty.
     *
     * @param x x input.
     * @param y y input.
     *
     * @return Validity of placement of the disc.
     */
    private boolean isValidPosition(int x, int y)
    {
        // Your Code Goes Here!
        return true;//change it to something that makes sense
    }

    /**
     * Returns the size of this board.
     * @return Returns size of board
     */
    public int size()
    {
        return size;
    }

    /**
     * This method is used to check for a tie
     * @return true if tie, false otherwise
     */
    private boolean isBoardFull(){
        if(counter>=Math.pow(size,2))
            return true;
        return false;
    }
}
