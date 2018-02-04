package edu.jsu.mcis;

public class TicTacToeModel{
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    public Mark[][] grid; /* Game grid */
    public boolean xTurn; /* True if X is current player */
    public int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        for(int row = 0; row < grid.length; row++){
            for(int column = 0; column < grid[row].length; column++){
                this.grid[row][column] = Mark.EMPTY;
            }
        }       
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        if (xTurn = true && isValidSquare(row,col) && !isSquareMarked(row,col)){
            this.grid[row][col] = Mark.X;
            this.xTurn = false;
            return true;
        }
        else if (xTurn = false && isValidSquare(row,col) && !isSquareMarked(row,col)){
            this.grid[row][col] = Mark.O;
            this.xTurn = true;
            return true;
            }
        else
            return false;
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        if(col < this.width && col >= 0 && row < this.width && row >= 0)
			return true;
		else
			return false;      
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        if(grid[row][col] == Mark.EMPTY)
            return false;
        else
            return true;         
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
       return grid[row][col];          
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        Mark mark = (!this.xTurn) ? Mark.X : Mark.O;
        
        if(isMarkWin(mark) && isXTurn())
            return Result.O;
        if(isMarkWin(mark) && !isXTurn())
            return Result.X;
        if(isTie())
            return Result.TIE;
        else
            return Result.NONE;
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        
        if(slashWin(mark))
            return true;
        if(horiWin(mark))
            return true;
        if(vertWin(mark))
            return true;
        if(backslashWin(mark))
            return true;
        else
            return false;
    }
    private boolean slashWin(Mark mark){
        int markerCount = 0;
        
        for (int i = 0; i < this.width; ++i){
            for (int j = 0; j < this.width; ++j){
                if (j == (this.width - 1 - i) && grid [i][j] == mark)
                    ++markerCount;
            }
        }
        return markerCount == this.width;
    }
    private boolean backslashWin(Mark mark){
        int markerCount = 0;
        
        for(int i = 0; i < this.width; ++i){
            for(int j = 0; j < this.width; ++j){
                if(i == j && grid[i][j] == mark)
                    ++markerCount;
            }
        }
        return markerCount == this.width;
    }
    private boolean horiWin(Mark mark){
        int markerCount = 0;
        
        for(int i = 0; i <this.width; ++i){
            for(int j = 0; j < this.width; ++j){
                if(grid[i][j] == mark)
                    ++markerCount;
            }
        }
        return markerCount == this.width;
    }
    private boolean vertWin(Mark mark){
        int markerCount = 0;
    
        for(int j = 0; j < this.width; ++j){
            for(int i = 0; i <this.width; ++i){
                if(grid[i][j]== mark)
                    ++markerCount;
            }   
        }
        return markerCount == this.width;
    }
    
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* Needs to account for more possible grid sizes */
        int markerCount = 9;
            for (int i = 0; i < this.width; ++i){
                for (int j = 0; j < this.width; ++j){
                    if(grid[i][j] == Mark.EMPTY)
                        --markerCount;
                }
            }
        return markerCount == 9; 
    }

    public boolean isGameover(){
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn(){
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth(){
        
        /* Getter for width */
        
        return width;
        
    }
    
}