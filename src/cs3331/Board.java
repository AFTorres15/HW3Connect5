    package cs3331;

    //import java.security.InvalidParameterException;
//I am testing dumb stuff try to ckedkdkdsfjfsrajo
    /**
     * Contains the model for the Connect Five board. (No GUI elements should placed here.)
     *
     * @author Andrea Torres
     *
     */
    class Board{
        private Square[][] tiles;
        private boolean[][] isFilled;
        private int counter=0;

        /** Defines the size of the board */
        private final int size;
        /**
         * Constructor including size of board
         * @param size Board Size
         */
        Board(int size){
                this.size = size;
                tiles = new Square[size][size];
                isFilled = new boolean[size][size];

        }
        /**
         * Adds a disc to the game board.
         *
         * @param x x coordinate of where the disc needs to be placed.
         * @param y y coordinate of where the disc needs to be placed.
         */
        void addDisc(int x, int y, Player player)throws InValidDiskPositionException,PlayerWonException, BoardFullException{
            if(isBoardFull())
                throw new BoardFullException();//throw an exception
            if(isValidPosition(x,y)) {
                tiles[y][x] = new Square(x, y, player);
                isFilled[y][x]=true;
                if(checkForWin(tiles[y][x],player)) {
                    throw new PlayerWonException();
                }

            }else{
                throw new InValidDiskPositionException();
            }
        }
        /**
         * Checks if input positions is valid. Checks if valid x-y range. Also checks if position is empty.
         *
         * @param x x input.
         * @param y y input.
         *
         * @return Validity of placement of the disc.
         */
        private boolean isValidPosition(int x, int y){
            // Your Code Goes Here!
            return !isFilled[y][x];
        }

        /**
         * Returns the size of this board.
         * @return Returns size of board
         */
        int size()
        {
            return size;
        }
        Player getPlayer(int x, int y){
             return tiles[y][x].getPlayer();
        }

        /**
         * This method is used to check for a tie
         * @return true if tie, false otherwise
         */
        private boolean isBoardFull(){
            return counter >= Math.pow(size, 2);
        }

        private boolean checkForWin(Square square, Player player){
            if(((checkHelper(square.getX(),square.getY(),player.getSymbol(),0,-1)+checkHelper(square.getX(),square.getY(),player.getSymbol(),0,1)))>=6) {
                // System.out.println("Current Points:" + currpoints);
                return true;
            }
            if(checkHelper(square.getX(),square.getY(),player.getSymbol(),-1,0)+checkHelper(square.getX(),square.getY(),player.getSymbol(),1,0)>=6)
                return true;
            if(checkHelper(square.getX(),square.getY(),player.getSymbol(),-1,-1)+checkHelper(square.getX(),square.getY(),player.getSymbol(),1,1)>=6)
                return true;
            return checkHelper(square.getX(), square.getY(), player.getSymbol(),-1,1) + checkHelper(square.getX(), square.getY(), player.getSymbol(),1,-1) >= 6;
        }

        private int checkHelper(int x,int y,char player,int dx,int dy){
            try {
                if (tiles[y][x].getPlayer().getSymbol() == player) {
                    return 1 + checkHelper(x+dx , y+dy, player,dx,dy);
                }
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        /*//upckeck dx 0 dy -1
        private int upCheck(int x, int y,char player){
            try {
                if (tiles[y][x].getPlayer().getSymbol() == player) {
                    return 1 + upCheck(x , y-1, player);
                }
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //dx 0,dy 1 downCheck
        private int downCheck(int x, int y, char player){
            try {
                if(tiles[y][x].getPlayer().getSymbol()== player)
                    return 1+downCheck(x,y+1,player);

            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //left check dx -1,dy 0
        private int leftCheck(int x, int y, char player){
            try {
                if (tiles[y][x].getPlayer().getSymbol() == player)
                    return 1 + leftCheck(x-1, y, player);
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //right check dx 1 dy 0
        private int rightCheck(int x, int y, char player){
            try {
                if (tiles[y][x].getPlayer().getSymbol() == player) {
                    return 1 + rightCheck(x+1, y, player);
                }
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //left up chekc dx -1 dy -1
        private int leftUpCheck(int x, int y, char player){
            try{
                if(tiles[y][x].getPlayer().getSymbol()==player){
                    return 1+leftUpCheck(x-1,y-1,player);
                }
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //right dwn check 1,1
        private int rightDownCheck(int x, int y, char player){
            try{
                if(tiles[y][x].getPlayer().getSymbol()==player)
                    return 1+rightDownCheck(x+1,y+1,player);
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //left dwn check dx -1 dy 1
        private int leftDownCHeck(int x,int y, char player){
            try {
                if(tiles[y][x].getPlayer().getSymbol()==player){
                    return 1+leftDownCHeck(x-1,y+1,player);
                }
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }
        //dx1 dy -1 right up check
        private int rightUpCheck(int x, int y, char player){
            try {
                if(tiles[y][x].getPlayer().getSymbol()== player)
                    return 1+rightUpCheck(x+1,y-1,player);
            }catch (NullPointerException | ArrayIndexOutOfBoundsException e){
                return 0;
            }
            return 0;
        }*/
    }
