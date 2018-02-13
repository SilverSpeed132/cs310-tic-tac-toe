# cs310-tic-tac-toe

What is this project?

This project is a GUI based Tic-Tac-Toe simulator.  
When TicTacToe.java is run, the program boots up a GUI system taht has a 3x3 grid of clickable buttons.
The logic for the board is ran through multiple times to check for which mark to make and if there is a winner or tie.

Why was it made?

I made this for a Software Engineering class project for a grade.  It started out as a text based tic-tac-toe simulator on the command line
and became a GUI based one later on (you will see old remnants of the text based version littered throughout the program.)  A portion of
the code was provided to me by my professor.

Software used for the project thus far:
- Gradle v4.5
- Java JDK 1.8.0_162

Overview of what is contained in the surface folders of this repository:
- .gradle
  - These are files created by the Gradle Build Tool when the project is built
  
- build
  - Test reports from the ROBOT file tests
  - a .jar file that can be used to run the program (in libs)
  - jacoco test report files
  
- build.gradle
  - gradle file provided by my professor for the purposes of the project

- src
  - main/java/edu/jsu/mcis
    - This folder contains the main code of the program which I will explain in detail further down
  - main/java/keywords
    - 
  - test/acceptancetest
    - contains two ROBOT files used to test the functionality of the program (provided by professor)
  - test/java/edu/jsu/mcis
    - contains code that the ROBOT files use to test the program (provided by professor)
    
 
Main Program Explanation:
- TicTacToe.java
  - The beginning of the main body of this program starts with taking the width desired by the board, which is be default 3 (although
  args can be used to make it more or less)
  - After that, the program sets up a Model, View, and Controller for the program to use
  - Lastly, the program sets up the GUI Frame.
- TicTacToeController.java
  - Most of this file is left unused in the GUI version of this program, but I will explain what it does here anyway.
  - The Constructor method sets up interaction with the Model and View files, as well as creates a Scanner called "keyboard" that was
  used to take input from a user
  - the ControlModel method shows a user a prompt that the program is ready to receive a new command, then takes the input and makes a
  mark on the grid or shows an input error accordingly
- TicTacToeModel.java
  - This file contains the main portion of the logic for the simulator
  - Two enumerator methods, "Mark" and "Result," are made by the file, which will be used to make marks and return a result message to
  the user, respectively.
  - the Constructor method sets the variable xTurn to true so that the game starts on the X Player's turn, as well as creating a grid,
  which is a 2D array of type Mark, for the file to use to simulate the game.
  - the makeMark method checks for the player turn, if a square is a markable square, and if the square exists at all on the board,
  and if the player's command is valid, then the program makes a mark and then swaps player turns
  - the isValidSquare and isSquareMarked methods check to make sure a square exists on the board and if the square is marked,
  respectively
  - the getMark method just returns whatever mark is on a square
  - the getResult method runs through the isMarkWin method and isXTurn methods to set a winner or tie for the current game
  - the isMarkWin method runs through the possible win conditions to see if a player has won the game or not
  - slashWin, backslashWin, horiWin, and vertWin are all methods that the isMarkWin uses to determine the winner of the game and
  check for their respective names' win conditions
  - the isTie Method returns whether or not the game has become a tied game or not
  - isGameOver is used to tell when the game is over or not
  - isXTurn and getWidth are getter methods to get to certain variables
- TicTacToeView.java
  - The constructor acts to both set up the GUI's functions as well as set up interaction with TicTacToeModel
  - ViewModel is a remnant of the text-based version of the program's view, and sets up the command line to print out a grid that
  can be viewed by a user to visually see the game
  - showNextMovePrompt and showInputError are also remnants, and printed strings that would tell the user to make a move or show an
  input error, respectively.
  - actionPerformed sets up the logic for the buttons on the GUI grid
  - if the game is not over:
    - first the file collects the name of the clicked button (which will be in a format of "'Square' + row number + column number")
      - it then parses the two integers from the column name
      - the program then runs the numbers as the player inputs, acting as the coordinates on the grid
  - if the game is over:
    - the file changes the text of the result label to display the winning mark
    
