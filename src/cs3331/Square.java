package cs3331;

/**
 * @author Andrea Torres
 */
public class Square {
    private int x, y;
    private Player currPlayer;

    Square(int x, int y, Player player) {
        this.x = x;
        this.y = y;
        this.currPlayer = player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Player getPlayer() {
        return currPlayer;
    }
}
