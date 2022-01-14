/* CST8110 - Introduction to Computer Programming
 * Section: 521
 * Semester: 19F
 * Professor: Morrison
 * Student ID: 040986555
 * Student Email: abee0001@algonquinlive.com
 * Practical Assessment2
 */
public class Column {	//Class to make each instance of a column

	private static final int MAX_HEIGHT = 6;	//Max height of the column
	private int height = 0;		//Height variable
	private char[] column;	//Column array

	public Column() {	//Constructor to initialise each element with a blank character
		column = new char[MAX_HEIGHT];	//Defining the array
		for (int i = 0; i < MAX_HEIGHT; i++) {	//Loop to place elements in
			column[i] = ' ';
		}
	}

	public char get(int row) {	//Method to find the specific element in the column
		if (row < 0 || row > 5){	//If statement to validate the input
			return ' ';
		}
		else{
			return column[row];	//Returns the value
		}

	}

	public boolean put(char token) {	//Method to place the approach character into the correct element
			if (column[0] != ' ') {	//If statement to validate it can be done
				System.out.println("Sorry that column is full.");
				return false;
			} else {
				for (int row = column.length - 1; row >= 0; row--) {	//Loop to place the token in
					if (column[row] == ' ') {
						column[row] = token;
						height++;
						return true;
					}
				}
			}
		return false;
	}

	public boolean checkVictory(char token) {	//Method to check if there is 4 values in a row
		int streakCounter = 0;	//Integer variable to count the steak

		for (int row = 0; row < column.length; row ++){	//Loop to count each instance of a value
			 if(column[row] == token){	//If the value is the same, then count up
				streakCounter++;
			 }
			 else {	//If not the same the reset to 0
			 	streakCounter = 0;
			 }
			 if (streakCounter == 4){	//If the counter is equal to 4 then there is a victory
			 	return true;
			 }
		}
		return false;
	}

	public int getHeight() {	//Method to returns the height
		return height;
	}
}
