/* CST8110 - Introduction to Computer Programming
 * Section: 521
 * Semester: 19F
 * Professor: Morrison
 * Student ID: 040986555
 * Student Email: abee0001@algonquinlive.com
 * Practical Assessment2
 */
public class Main {		//Class to start the game

	public static void main(String[] args) {
		
		NibbleNabble game = new NibbleNabble();	//Make a new instance of the game
		do {	//Do loop to play the game while quiz is not true


			game.playGame();

		}
		while (!game.quit());

	}
	
}
