package reversiGame;

import java.util.ArrayList;

public class Board {
	
	private	int size;
	private	ArrayList<ArrayList<Square>> array;

	/**
	 * function name: Board
	 * input: the board's size
	 * output: new object of board
	 * operation: constructor
	 */
	public Board(int s) {
		this.array = new ArrayList<ArrayList<Square>>();
		this.size = s;
		for (int i = 0; i < this.size; i++) {
			ArrayList<Square> l = new ArrayList<Square>();
			for (int j = 0; j < this.size; j++) {
				l.add(new Square(i, j));
			}
			this.array.add(l);
		}

		this.array.get(this.size/2 -1).get(this.size/2 -1).setType('O');
		this.array.get(this.size/2).get(this.size/2).setType('O');
		this.array.get(this.size/2 -1).get(this.size/2).setType('X');
		this.array.get(this.size/2).get(this.size/2 -1).setType('X');
	}

	/**
	 * function name: getArray
	 * input: void
	 * output: ArrayList<ArrayList<Square>>
	 * operation: returns the board's array
	 */
	public ArrayList<ArrayList<Square>> getArray() {
		return this.array;
	}

	/**
	 * function name: isEmpty
	 * input: x and y indexes of the board's array
	 * output: boolean
	 * operation: checks if the given location is empty
	 */
	public boolean isEmpty(int x, int y){
		if (this.array.get(x).get(y).getType() == ' ') {
			return true;
		}
		return false;
	}

	/**
	 * function name: isOutOfBounderies
	 * input: x and y indexes
	 * output: boolean
	 * operation: checks if the given location is out of the array's boundaries
	 */
	public boolean isOutOfBounderies(int x, int y){
		if (x < 0 || x >= this.size || y < 0 || y >= this.size) {
			return true;
		}
		return false;
	}

	/**
	 * function name: get type
	 * input: x and y indexes
	 * output: char
	 * operation: returns the state of the given location in the array
	 */
	public char getType(int x, int y) {
		return this.array.get(x).get(y).getType();
	}

	/**
	 * function name: set type
	 * input: x and y indexes, char type
	 * output: void
	 * operation: set the state of the given location in the array to the desired type
	 */
	public void setType(int x, int y, char type) {
		this.array.get(x).get(y).setType(type);
	}


	/**
	 * function name: isBoardFull
	 * input: void
	 * output: boolean
	 * operation: checks if the board is full
	 */
	public boolean isboardfull() {
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (isEmpty(i, j)) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * function name: getSize
	 * input: void
	 * output: int
	 * operation: returns the board's size
	 */
	public int getSize() {
		return this.size;
	}


	/**
	 * function name: getSquare
	 * input: int x, int y
	 * output: Square
	 * operation: returns the square in the desired location
	 */
	public Square getSquare(int x, int y) {
		return this.array.get(x).get(y);
	}

	/**
	 * function name: getScore
	 * input: char type
	 * output: int
	 * operation: returns the number of times the given type occurs in the board
	 */
	public int getScore(char type) {
		int score = 0;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.array.get(i).get(j).getType() == type){
					score++;
				}
			}
		}
		return score;
	}
	/**
	 * function name: whoWin
	 * input: void
	 * output: Winner
	 * operation: checks who won - X, O or it's a tie.
	 */
	public String whoWin() {
		int x = 0;
		int o = 0;
		for (int i = 0; i < this.size; i++) {
			for (int j = 0; j < this.size; j++) {
				if (this.array.get(i).get(j).equals('X')) {
					x++;
				} else if (this.array.get(i).get(j).equals('O')) {
					o++;
				}
			}
		}
		if (x > o) {
			return "Player 1";
		} else if (o > x) {
			return "Player 2";
		} else {
			return "Both of you!";
		}
	}
}
