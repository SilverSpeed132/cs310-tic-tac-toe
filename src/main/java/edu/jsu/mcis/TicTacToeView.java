package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;
    private boolean initializeGrid = false;
    /* CONSTRUCTOR */    
    JButton[][] grid;
    JPanel panel;
    private JLabel resultLabel;
    public JPanel container;
	
    public TicTacToeView(TicTacToeModel model) {
        
        //Sets up the GUI
        
        this.model = model;
        
     
        panel = new JPanel();
        panel.setLayout(new GridLayout(model.width,model.width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        resultLabel.setText("Winner: ");
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
       grid = new JButton[3][3];
        for(int row=0; row < 3; row++){
            for(int col =0; col < 3; col++){
                grid[row][col] = new JButton();
                grid[row][col].addActionListener(this);
                
                grid[row][col].putClientProperty("row", row);
                grid[row][col].putClientProperty("col", col);
                grid[row][col].setPreferredSize(new Dimension(64,64));
                grid[row][col].setLocation((row*20)+20,(col*20)+20);
                    
                grid[row][col].setName("Square" + row + col);
                grid[row][col].setText("-");
                panel.add(grid[row][col]);
            }
        }
        
        setSize(600,600);
        setVisible(true);
        
        container.add(panel);   
        container.add(resultLabel);
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

       resultLabel.setText(r);
    }

        @Override
        public void actionPerformed(ActionEvent e){
            
        //Gets the button pressed and its relevant properties
        JButton btn = (JButton) e.getSource();
        String select = btn.getName();
        
        
        int row = Integer.parseInt(select.substring(6,7));
        int col = Integer.parseInt(select.substring(7,8));
        
        //If game is not over, makes a button press behave properly
        if (!model.isGameover()){
            if (model.isValidSquare(row,col) && !model.isSquareMarked(row,col)){
                if(model.isXTurn()){
                    btn.setText("X");
                    model.makeMark(row,col); 
                
                }
                else{
                    btn.setText("O");
                    model.makeMark(row,col);
               
                    }
                }
            }
        //If game is over, sets the result label to display the winner/tie status
        if(model.isGameover()){
            if(null != model.getResult())
                switch (model.getResult()) {
                    case X:
                        this.showResult("X");
                        break;
                    case O:
                        this.showResult("O");
                        break;
                    case TIE:
                        this.showResult("TIE");
                        break;
                    default:
                        break;
                }       
            }
        }
    }	
