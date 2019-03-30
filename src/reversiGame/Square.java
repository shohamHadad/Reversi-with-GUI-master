package reversiGame;

public class Square {

	private	int x;
	private	int y;
	private char type;

	/**
	 * function name: Square
	 * input: 2 integers
	 * output: a new Square object
	 * operation: constructor
	 */
	public Square(int x, int y) {
		this.x = x;
		this.y = y;
		this.type = ' ';
	}

	/**
	 * function name: print
	 * input: void
	 * output: void
	 * operation: print out the square values
	 */
	public void print() {
		System.out.print("(" + this.x + ","+ this.y + ")");
	}

	/**
	 * function name: getX
	 * input: void
	 * output: the square's x value
	 * operation: return the square's x value
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * function name: getY
	 * input: void
	 * output: the square's y value
	 * operation: return the square's y value
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * function name: equals
	 * input: Square
	 * output: boolean
	 * operation: checks if the given square is equal to this square
	 */
	public boolean equals(Square other) {
		if (other.getX() == this.x && other.getY() == this.y) {
			return true;
		}
		return false;
	}

	/**
	 * function name: setType
	 * input: char
	 * output: void
	 * operation: set the square's type
	 */
	public void setType(char t) {
		this.type = t;
	}

	/**
	 * function name: getType
	 * input: void
	 * output: char
	 * operation: returns the square's type
	 */
	public char getType() {
		return this.type;
	}
	
	public boolean isEmpty() {
		if (this.type == ' ') {
			return true;
		}
		return false;
	}
}
