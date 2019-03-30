package GUI;

import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import reversiGame.Square;

public class GUISquare extends BorderPane {
	private Square square;
	private ReversiBoard rBoard;
	private SquareListener listener;
	private boolean entered;
	private ArrayList<Square> possibleMoves;
	private int edgeSize;

	/**
	 * function name: GUISquare
	 * input: ReversiBoard, Square, SquareListener
	 * output: new object of GUISquare
	 * operation: constructor
	 */
	public GUISquare(ReversiBoard rb, Square s, SquareListener listener) {
		this.square = s;
		this.rBoard = rb;
		this.listener = listener;
		this.entered = false;
	}

	
	/**
	 * function name: draw
	 * input: int, ArrayList<Square>
	 * output: void
	 * operation: draw the GUISquare
	 */
	public void draw(int edgeSize, ArrayList<Square> possibleMoves) {
		this.edgeSize = edgeSize;
		this.possibleMoves = possibleMoves;
		// draw the rectangle
		Rectangle rectangle = new Rectangle(edgeSize, edgeSize);
		if ((this.square.getX() + this.square.getY()) % 2 == 0) {
			if (this.entered) {
				rectangle.setFill(Color.rgb(247, 204, 157));
			} else {
				rectangle.setFill(Color.rgb(255, 255, 204));
			}
		} else {
			if (this.entered) {
				rectangle.setFill(Color.rgb(170, 100, 170));
			} else {
				rectangle.setFill(Color.rgb(200, 162, 200));
			}
		}
		rectangle.setStroke(Color.rgb(85, 31, 85));
		this.setCenter(rectangle);
		this.rBoard.add(this, this.square.getY(), this.square.getX());

		// if there's a disk on this square, draw it
		if (!this.square.isEmpty()) {
			BorderPane borderPane = new BorderPane();
			Circle c = new Circle();
			c.setRadius(edgeSize / 2.0 - 4);
			c.setStroke(Color.BLACK);
			if (this.square.getType() == 'X') {
				c.setFill(SettingData.getPlayer1Color());
			} else {
				c.setFill(SettingData.getPlayer2Color());
			}
			borderPane.setCenter(c);
			this.rBoard.add(borderPane, this.square.getY(), this.square.getX());
		}
		// set the listener
		this.setOnMouseClicked(event -> {this.listener.clickEvent(this.square);});
//		for (int i = 0; i < possibleMoves.size(); i++) {
//			if (possibleMoves.get(i).equals(this.square)) {
//				this.setOnMouseEntered(event -> {this.listener.hoverEvent(this);});
//				this.setOnMouseExited(event -> {this.listener.hoverEvent(this);});		
//			}
//		}
	}

	
	/**
	 * function name: isEmpty
	 * input: void
	 * output: void
	 * operation: check if the inner square has a disk
	 */
	public boolean isEmpty() {
		return this.square.isEmpty();
	}

	
	/**
	 * function name: setHover
	 * input: void
	 * output: void
	 * operation: update private entered and draw the square
	 */
	public void setHover() {
		this.entered = !this.entered;
		draw(this.edgeSize, this.possibleMoves);
	}


	/**
	 * function name: setType
	 * input: char
	 * output: void
	 * operation: set the square's type
	 */
	public void setType(char t) {
		this.square.setType(t);
	}

	/**
	 * function name: getType
	 * input: void
	 * output: char
	 * operation: returns the square's type
	 */
	public char getType() {
		return this.square.getType();
	}

	
	/**
	 * function name: getSquare()
	 * input: void
	 * output: Square
	 * operation: returns the inner square
	 */
	public Square getSquare() {
		return this.square;
	}
}
