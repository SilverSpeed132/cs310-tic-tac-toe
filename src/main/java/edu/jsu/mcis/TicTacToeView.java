package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
       System.out.println("");
        for(int i = 0; i < model.getWidth() + 2; ++i){
            
            if(i < 2)
                System.out.print(" ");
            else
                System.out.print(i - 2 + "");
            
        }
        System.out.println('\n');
        for(int i = 0; i < model.getWidth(); ++i){
			
            for(int j = 0; j < model.getWidth() + 2; ++j){
		
                if(j > 1)
                    System.out.print(model.getMark(i, j - 2));
                else if(j != 1)
                    System.out.print(i + "");
                else
                    System.out.print(" ");
                            
            }
		System.out.println("");
		}		
		System.out.println(""); 
        
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */
        int playerNum;
        String playerMark;
        if (model.isXTurn()){
            playerNum = 1;
            playerMark = "(X)";}
        else  {
            playerNum = 2;
            playerMark = "(O)";}
        System.out.println("Player " + playerNum + " " + playerMark + " Move:");
        System.out.print("Enter the row and column numbers, separated by a space: ");
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        System.out.println("This is not a correct input (Inputs must be a space apart).");

    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}