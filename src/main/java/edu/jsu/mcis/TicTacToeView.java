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
        
        this.model = model;
        
     
        panel = new JPanel();
        panel.setLayout(new GridLayout(model.width,model.width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        resultLabel.setText("Winner: ");
        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
       grid = new JButton[3][3];
        for(int i=0; i < 3; i++){
            for(int j =0; j < 3; j++){
                grid[i][j] = new JButton();
                grid[i][j].addActionListener(this);
                
                grid[i][j].putClientProperty("row", i);
                grid[i][j].putClientProperty("column", j);
                grid[i][j].setPreferredSize(new Dimension(64,64));
                grid[i][j].setLocation((i*20)+20,(j*20)+20);
                    
                grid[i][j].setName("Square" + i + j);
                grid[i][j].setText("-");
                panel.add(grid[i][j]);
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
        JButton btn = (JButton) e.getSource();
        String select = btn.getName();
        
        int row = Integer.parseInt(select.substring(6,7));
        int col = Integer.parseInt(select.substring(7,8));
        
        
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

    }	
