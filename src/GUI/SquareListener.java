package GUI;

import reversiGame.Square;

public class SquareListener {

	private ReversiController rc;
	
	
	/**
	 * function name: SquareListener
	 * input: ReversiController
	 * output: new object of SquareListener
	 * operation: constructor
	 */
	public SquareListener(ReversiController controller) {
		this.rc = controller;
	}
	
	
	/**
	 * function name: clickEvent
	 * input: Square s
	 * output: void
	 * operation: executes the user's mouseClick via playOneTurn()
	 */
	public void clickEvent(Square s) {
		rc.playOneTurn(s);
	}
	
	/**
	 * function name: hoverEvent
	 * input: GUISquare s
	 * output: void
	 * operation: notify the GUISquare that it has been hovered on
	 */
	public void hoverEvent(GUISquare s) {
		s.setHover();
	}
}
