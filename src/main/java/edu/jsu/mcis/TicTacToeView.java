package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class TicTacToeView extends JFrame{

    private TicTacToeModel model;
    private boolean initializeGrid = false;
    /* CONSTRUCTOR */    
    JButton[][] grid;
    JPanel panel;
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
        setTitle("TicTacToe");
        panel = new JPanel();
        panel.setLayout(new GridLayout(model.width,model.width));
        
       grid = new JButton[3][3];
        for(int i=0; i < 3; i++){
            for(int j =0; j < 3; j++){
                grid[i][j] = new JButton();
                grid[i][j].addActionListener(new e());
                
                grid[i][j].putClientProperty("row", i);
                grid[i][j].putClientProperty("column", j);
                   
                    
                grid[i][j].setName("Square" + i + j);
                grid[i][j].setText("-");
                panel.add(grid[i][j]);
            }
        }
        
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        add(panel);       
    }
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
       if(initializeGrid == false){
            System.out.print("\n  012\n\n0 ---\n1 ---\n2 ---\n\n\n\n");
            initializeGrid = true;
       }
       else{
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