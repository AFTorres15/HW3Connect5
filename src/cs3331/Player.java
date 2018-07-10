package cs3331;

public class Player {
    private int playerName;
    private char symbol;
    private boolean isReal;

    public Player(int currPlayer, char symbol) {
        this.playerName = currPlayer;
        this.symbol = symbol;
        isReal = false;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getPlayerName() {
        return playerName;
    }
    //Eventually we will implement the AI stuff here or related to here that is why we have the irReal
}
