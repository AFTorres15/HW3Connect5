package cs3331;

/**
 * @author Andrea Fernanda Torres
 */
public class Player {
    private int playerName;
    private char symbol;
    private boolean isReal;
    public Player(int currPlayer,char symbol){
        this.playerName=currPlayer;
        this.symbol=symbol;
        isReal=true;
    }
    char getSymbol(){
        return symbol;
    }
    public int getPlayerName(){
        return playerName;
    }
    //Eventually we will implement the AI stuff here or related to here that is why we have the irReal
}
