package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;

public class SettingsController {

	@FXML
	private ComboBox firstPlayer;

	@FXML
	private ComboBox colorPlayer1;

	@FXML
	private ComboBox colorPlayer2;

	@FXML
	private ComboBox boardSize;

	@FXML
	private Button ok;


	ObservableList<String> firstPlayerList =
			FXCollections.observableArrayList("Player 1", "Player 2");

	ObservableList<String> colorPlayerList =
			FXCollections.observableArrayList("Black", "White", "Purple", "Blue", "Green", "Yellow", "Orange",
					"Red");

	ObservableList<String> boardSizeList =
			FXCollections.observableArrayList("4", "6", "8", "10", "12", "14", "16", "18", "20");

	/**
	 * function name: initialize
	 * input: void
	 * output: void
	 * operation: initialize the window of the settings.
	 */
	@FXML
	private void initialize() {
		firstPlayer.setValue("Player 1");
		firstPlayer.setItems(firstPlayerList);

		colorPlayer1.setValue("Black");
		colorPlayer1.setItems(colorPlayerList);

		colorPlayer2.setValue("Purple");
		colorPlayer2.setItems(colorPlayerList);

		boardSize.setValue("8");
		boardSize.setItems(boardSizeList);
	}

	/**
	 * function name: end
	 * input: void
	 * output: void
	 * operation: save the settings the player has selected to a file and then returns to main menu
	 */
	@FXML
	protected void end() {
		String StringfirstPlayer = firstPlayer.getValue().toString();
		String StringPlayer1Color = colorPlayer1.getValue().toString();
		String StringPlayer2Color = colorPlayer2.getValue().toString();
		String StringBoardSize = boardSize.getValue().toString();

		Writer writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("filename.txt"), "utf-8"));
			writer.write("first player: " + StringfirstPlayer + "\n");
			writer.write("color player1: " + StringPlayer1Color + "\n");
			writer.write("color player2: " + StringPlayer2Color + "\n");
			writer.write("board size: " + StringBoardSize + "\n");
		} catch (IOException ex) {
			ex.printStackTrace();			
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		Menu menu = new Menu();
		try {
			menu.start((Stage)ok.getScene().getWindow());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
