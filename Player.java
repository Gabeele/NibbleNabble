/* CST8110 - Introduction to Computer Programming
 * Section: 521
 * Semester: 19F
 * Professor: Morrison
 * Student ID: 040986555
 * Student Email: abee0001@algonquinlive.com
 * Practical Assessment2
 */
public class Player {	//Class to create a player

	private String name; //Property PlayerName
	private char token; 	//Property Token

	public Player() {	//No-args constructor initializes the name to Computer and token to the letter O.
		name = "Computer";	//Sets the name to Computer
		token =  'O' ;	//Sets the token to O
	}

	public Player(String name) {	//Constructor to get a name for the user player and token set to X
		this.name =  name;
		token = 'X';
		
	}

	public String getName() {	//Method to return the name when called
		return name;
	}

	public char getToken(){	//Method to return the token when called
		if( name == "Computer") {	//If statement to validate the player and return the correct value
			return 'O';
		}
		else{
			return 'X';

		}
	}

}
