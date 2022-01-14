/* CST8110 - Introduction to Computer Programming
 * Section: 521
 * Semester: 19F
 * Professor: Morrison
 * Student ID: 040986555
 * Student Email: abee0001@algonquinlive.com
 * Practical Assessment2
 */
public class Board {	//Class to create and solve the game board

	private final static int NUM_ROWS = 6;	//Number of rows on the board
	private final static int NUM_COLS = 7;	//Number of columns on the board
	private Column[] board = new Column[NUM_COLS];	//Array of Column objects which contain values
	private Object Column;	//Column Object
	private Object Board;	//Board object

	public Board() {	//Constructor to loop through and initialize each element as a new column
		for(int i = 0; i < NUM_COLS; i++){
			board[i] = new Column();
		}
	}

	public boolean makeMove(int column, char token) {	//Method to take an input, validate it, then place the correct token on the board
		if (column > 7 || column <= 0){		//If statement to validate
			System.out.println("You have entered an out of bounds number. Pick from 1 to 7.");
			return false;
		}
		else{
			return board[column-1].put(token); //-1 is to make sure the column is correlated to the display
		}
	}
	

	public boolean checkVictory(char token) {	//Check the victories vertical and horizontally
		for(int col = 0; col < NUM_COLS; col++){	//For Loop to check if each column has a 4 in a row vertically
			board[col].checkVictory(token);
			if(board[col].checkVictory(token)){
				return true;
			}
		}

		int steakCounter = 0;	//Integer variable to count the steakCounter. Used in the For Loop
		for(int row = 0; row < NUM_ROWS; row++){	//For Loop to check horizontal wins
			steakCounter = 0;	//Ensures Reset the row to 0
			for (int col = 0; col < NUM_COLS ; col++){
				if (board[col].get(row)== token){
					steakCounter++;
				}
				else{
					steakCounter = 0;
				}
				if(steakCounter == 4){
					return true;
				}
			}
		}
		return false;
	}

	public boolean isFull() {	//Method to check to see if there is a tie

		int steakCounter = 0;	//Variable to count the steaks

			for(int row = 0; row< NUM_ROWS; row++) {	//For Loop to count up for rows and columns then validate if the character at that coordinate is ' '

				for (int col = 0; col < NUM_COLS; col++) {
					if (board[col].get(NUM_ROWS) == ' ') {
						steakCounter++;
					}
				}
			}
		//If statement when there is 4 spots left then return true
		return steakCounter == 4;

		}






	public void display() {	//Method to display the board and the appropriate values

		System.out.println(" 1 2 3 4 5 6 7  ");
		System.out.println("---------------");

		for(int row = 0; row< NUM_ROWS; row++){	//Loop to print out the values and make the board dimensions
			System.out.print("|");
			for (int col = 0; col < NUM_COLS; col++){
				System.out.print(board[col].get(row)+ "|");
			}

			System.out.println();
		}
		System.out.print("---------------\n");
		System.out.print(" 1 2 3 4 5 6 7 \n");
		System.out.println("\n");
	}

}
