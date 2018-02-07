package edu.jsu.mcis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew
 */
public class e implements ActionListener {
    //private TicTacToeModel model;
    private boolean xTurn;

        
    @Override
    public void actionPerformed(ActionEvent e){
      JButton btn = (JButton) e.getSource();
      //System.out.println(xTurn);
      btn.setText("X");

    } 
}
