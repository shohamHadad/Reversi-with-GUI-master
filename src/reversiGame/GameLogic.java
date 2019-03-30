package reversiGame;

import java.util.ArrayList;

public class GameLogic {
	private	Board board;
	private	int turns;

	/**
	 * function name: GameLogic
	 * input: board object
	 * output: new GameLogic object
	 * operation: constructor
	 */
	public GameLogic(Board board) {
		this.turns = 0;
		this.board = board;
	}

	/**
	 * function name: possibleMoves
	 * input: the players
	 * output: a vector of the possible moves (squares)
	 * operation: get all the current player's possible moves
	 */
	public ArrayList<Square> getPossibleMoves(Player current, Player opponent){
		ArrayList<Square> moves = new ArrayList<Square>();
		int size = this.board.getSize();
		// go over the board
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				// if the cell dosn't exist or is not empty, continue
				if (board.isOutOfBounderies(i,j) || board.getType(i,j) != ' ') {
					continue;
				}
				// if it's a valid move, push it in the vector
				if (isPossibleMove(i, j, current, opponent)) {
					moves.add(new Square(i, j));
				}
			}
		}
		return moves;
	}


	/**
	 * function name: isPossibleMove
	 * input: location and 2 players
	 * output: boolean
	 * operation: check the given location's each direction and returns true if any of them is valid
	 */
	public boolean isPossibleMove(int x, int y ,Player current, Player opponent) {
		// check upper left
		if (checkDirection(current, opponent, x-1, y-1, -1, -1, 0)) {
			return true;
		}
		// check upper mid
		if (checkDirection(current, opponent, x-1, y, -1, 0, 0)) {
			return true;
		}
		// check upper right
		if (checkDirection(current, opponent, x-1, y+1, -1, 1, 0)) {
			return true;
		}
		// check mid left
		if (checkDirection(current, opponent, x, y-1, 0, -1, 0)) {
			return true;
		}
		// check mid right
		if (checkDirection(current, opponent, x, y+1, 0, 1, 0)) {
			return true;
		}
		// check lower left
		if (checkDirection(current, opponent, x+1, y-1, 1, -1, 0)) {
			return true;
		}
		// check lower mid
		if (checkDirection(current, opponent, x+1, y, 1, 0, 0)) {
			return true;
		}
		// check mid right
		if (checkDirection(current, opponent, x+1, y+1, 1, 1, 0)) {
			return true;
		}
		return false;
	}


	/**
	 * function name: checkDirection
	 * input: 2 players, location, direction, counter of length
	 * output: boolean
	 * operation: recursive function that checks if a certain direction is valid.
	 */
	public boolean checkDirection(Player current, Player opponent, int x, int y, int dx, int dy, int length) {
		// if this cell is out of boundaries, or empty,
		// or it's our cell but we didn't pass any opponent's cells on the way
		if (this.board.isOutOfBounderies(x, y) || this.board.isEmpty(x, y)
				|| (this.board.getType(x, y) == current.getType() && length == 0)) {
			return false;
		}
		// if we've reached our own cell
		// (and there was an opponent's cell on our way)
		if (this.board.getType(x, y) == current.getType()) {
			return true;
		}
		// if this is an opponent's cell
		return checkDirection(current, opponent, x+dx, y+dy, dx, dy, length+1);
	}


	/**
	 * function name: flipInRightDirection
	 * input: 2 players, location and direction
	 * output: boolean
	 * operation: recursive function that flips the cells in a certain location, if valid.
	 */
	public boolean flipInRightDirection(Player current, Player opponent, int x, int y, int dx, int dy, int length) {
		// if this cell is out of boundaries or empty
		if (this.board.isOutOfBounderies(x, y) || this.board.isEmpty(x, y) || (this.board.getType(x,y) == current.getType() && length == 0)) {
			return false;
		}
		// if we've reached our own cell
		// (and there was an opponent's cell on our way)
		if (this.board.getType(x, y) == current.getType()) {
			return true;
		}
		// if this direction is good - it's the opponent's cell
		if (flipInRightDirection(current, opponent, x+dx, y+dy, dx, dy, length+1)) {
			// flip the disk
			this.board.setType(x, y, current.getType());
			return true;
		} else {
			return false;
		}
	}


	/**
	 * function name: turnDisks
	 * input: 2 players, move (Square)
	 * output: void
	 * operation: turns the disks in all the valid directions around the given move.
	 */
	public void turnDisks(Player current, Player opponent, Square move) {
		int x = move.getX();
		int y = move.getY();
		
		// check upper left
		if (flipInRightDirection(current, opponent, x-1, y-1, -1, -1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check upper mid
		if (flipInRightDirection(current, opponent, x-1, y, -1, 0, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check upper right
		if (flipInRightDirection(current, opponent, x-1, y+1, -1, 1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check mid left
		if (flipInRightDirection(current, opponent, x, y-1, 0, -1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check mid right
		if (flipInRightDirection(current, opponent, x, y+1, 0, 1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check lower left
		if (flipInRightDirection(current, opponent, x+1, y-1, 1, -1, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check lower mid
		if (flipInRightDirection(current, opponent, x+1, y, 1, 0, 0)) {
			this.board.setType(x, y, current.getType());
		}
		// check mid right
		if (flipInRightDirection(current, opponent, x+1, y+1, 1, 1, 0)) {
			this.board.setType(x, y, current.getType());
		}
	}


	/**
	 * function name: gameShouldStop
	 * input: 2 players
	 * output:boolean
	 * operation: check if the board is full or if both players can't make any more moves
	 */
	public boolean gameShouldStop(Player X, Player O) {
		if (getPossibleMoves(X,O).isEmpty() && getPossibleMoves(O,X).isEmpty()) {
			return true;
		}
		if (this.board.isboardfull()) {
			return true;
		}
		return false;
	}

	/**
	 * function name: whosTurn
	 * input: 2 players
	 * output: Player
	 * operation: returns the player who's turn it is
	 */
	public Player whosTurn(Player X, Player O) {
		if (turns % 2 == 0) {
			return X;
		}
		return O;
	}

	/**
	 * function name: updateTurns
	 * input: void
	 * output: void
	 * operation: promote turns by one.
	 */
	public void updateTurns() {
		this.turns++;
	}
}
