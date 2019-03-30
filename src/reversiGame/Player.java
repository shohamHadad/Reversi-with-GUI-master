package reversiGame;


public class Player {

	private	char type;

	/**
	 * function name: Player
	 * input: char
	 * output: new object of player
	 * operation: constructor
	 */
	public Player(char t) {
		this.type = t;
	}

	/**
	 * function name: getType
	 * input: void
	 * output: char
	 * operation: the player's type (X or O)
	 */
	public char getType() {
		return this.type;
	}

	/**
	 * function name: equals
	 * input: Player
	 * output: boolean
	 * operation: checks if the other player equals to this player.
	 */
	public boolean equals(Player other) {
		if (this.type == other.getType()) {
			return true;
		}
		return false;
	}
	
	/**
	 * function name: toString
	 * input: void
	 * output: String
	 * operation: returns a string that represent the player
	 */
	public String toString() {
		if (this.type == 'X') {
			return "Player 1";
		} else {
			return "Player 2";
		}
	}
}
