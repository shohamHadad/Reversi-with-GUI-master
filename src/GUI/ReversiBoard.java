package GUI;

import java.util.ArrayList;

import javafx.scene.layout.GridPane;

import reversiGame.Board;
import reversiGame.Square;

public class ReversiBoard extends GridPane {

	private Board board;
	private int boardSize;
	private GUISquare[][] squares;
	private SquareListener listener;


	/**
	 * function name: ReversiBoard
	 * input: Board, SquareListener
	 * output: new object of ReversiBoard
	 * operation: constructor
	 */
	public ReversiBoard(Board b, SquareListener l) {
		this.board = b;
		this.boardSize = this.board.getSize();
		this.listener = l;
		// create a matrix of GUISquares
		this.squares = new GUISquare[boardSize][boardSize];
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				this.squares[i][j] = new GUISquare(this, this.board.getSquare(i, j), this.listener);
			}
		}
	}

	
	/**
	 * function name: draw
	 * input: int, ArrayList<Square>
	 * output: void
	 * operation: draw the ReversiBoard
	 */
	public void draw(ArrayList<Square> possibleMoves) {
		// clear all that was on screen
		this.getChildren().clear();
		int squareSize = (int) this.getPrefHeight() / this.boardSize;
		// go over the squares
		for (int i = 0; i <  this.boardSize; i++) {
			for (int j = 0; j <  this.boardSize; j++) {
					this.squares[i][j].draw(squareSize, possibleMoves);
			}
		}
	}
}
