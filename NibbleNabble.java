/* CST8110 - Introduction to Computer Programming
 * Section: 521
 * Semester: 19F
 * Professor: Morrison
 * Student ID: 040986555
 * Student Email: abee0001@algonquinlive.com
 * Practical Assessment2
 */
import java.util.Scanner;	//Import a scanner
import java.util.Random;	//Import a random


public class NibbleNabble {	//Class of the game

	private Player currentPlayer;	//Current player is for who is playing
	private Player computer;	//Computer is an instance of a Player Class
	private Player user;	//User is an instance of a Player Class
	private Board board;	//Board is an instance of a Board Class
	private Scanner input;	//Input is an instance of the scanner class

	
	/** Outputs a welcome message. Prompts the user for their name, and instantiates a new Player with the name.
	 *  Initializes the Scanner, Board, user and computer variables.
	 */
	public NibbleNabble() {	//Constructor to initiate all the instances and start the prompt for the user
		//Creating new instances
		input = new Scanner(System.in);
		computer = new Player();
		board = new Board();


		System.out.println("Welcome to NibbleNabble.");
		System.out.print("Please enter your name and click enter to get started: ");	//Prompt for name input
		user = new Player(input.next());	//Set the user name to the input
		System.out.printf("\n");
		System.out.println("Happy to meet you. Lets get started.");

	}
	
	public boolean playGame() {	//Instructor created code

		while (true) {

			board.display();
			int column = 0;
			currentPlayer = togglePlayer();
			
			System.out.print(currentPlayer.getName() + " > ");
			
			while (column == 0) {
				
				if (currentPlayer == computer) {
					column = new Random().nextInt(7) + 1;
					System.out.println(column);
				} else {
					String move = input.next();
					if (move.toUpperCase().charAt(0) == 'Q')
						return false;
					
					column = Integer.parseInt(move);
				}
				
				if (!board.makeMove(column, currentPlayer.getToken())) {
					column = 0;
				}
				
			}
			
			if (currentPlayer == computer && board.checkVictory(currentPlayer.getToken())) {	//Edited to pass through a token
				board.display();
				System.out.println("\nOh no! The computer won!");
				break;
			} else if (currentPlayer == user && board.checkVictory(currentPlayer.getToken())) {	//Edited to add the player can win
				board.display();
				System.out.println("You are victorious!!!");
				break;
			} else if(currentPlayer == user && board.isFull()){		//Edit to add if the board isFull method is call and returns true then it is a tie game
				board.display();
				System.out.println("Tie game.");
			}
		}	
		
		return true;
	}

	public boolean quit() {	//Method to quit if certain values are used


		System.out.println("\nPlease enter any character to continue, or type Q or quit to exit the game.");	//Prompt
		input = new Scanner(System.in);	//The next input
		String isQuit = input.next();


		if (isQuit.equalsIgnoreCase("q") || isQuit.equalsIgnoreCase("quit")){	//If statement to check the values and run a new game or quit the code
			System.out.println("Thanks for playing!");
			return true;
		}
		else{	//If it not quitting then make a new board and start the game again
			System.out.println("We will keep playing!");
			board = new Board();
			System.out.print("Please enter your name and click enter to get started: ");
			user = new Player(input.next());
			return false;
		}
	}


	private Player togglePlayer() {	//Method to toggle between players
		if (currentPlayer == user){	//If statement to change players when called
			currentPlayer = computer;
		}
		else{
			currentPlayer = user;
		}
		return currentPlayer;
	}
}
