package cs3331;

public class Player {
    private String playerName;
    private char symbol;// should be 1 or 2
    private boolean isReal;

    public Player(String currPlayer, char symbol) {
        this.playerName = currPlayer;
        this.symbol = symbol;
        isReal = true;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getPlayerName() {
        return playerName;
    }
    //Eventually we will implement the AI stuff here or related to here that is why we have the irReal
}
