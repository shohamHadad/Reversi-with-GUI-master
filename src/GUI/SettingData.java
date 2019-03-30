package GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.paint.Color;

public class SettingData {
	
	private static int boardSize;
	private static Color player1Color;
	private static Color player2Color;
	private static int firstPlayer;
	
	
	/**
	 * function name: readSettingsFromFile
	 * input: void
	 * output: void
	 * operation: read the settings data from a file.
	 */
	public static void readSettingsFromFile() {
        String fileName = "filename.txt";
        FileReader fr = null;
        BufferedReader br = null;
        Map<String, String> settingsMap = new HashMap<String, String>();
        try {
        	fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String sCurrentLine;
            // read each line of the file, split it and put it in the map.
            while ((sCurrentLine = br.readLine()) != null) {
                String[] parts = sCurrentLine.split(": ");
                settingsMap.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // set the static privates according to the map.
        String order = settingsMap.get("first player");
        if (order.equals("Player 1")) {
        	firstPlayer = 1;
        } else {
        	firstPlayer = 2;
        }
        
        String colorPlayer1 = settingsMap.get("color player1");
        player1Color = Color.valueOf(colorPlayer1);

        String colorPlayer2 = settingsMap.get("color player2");
        player2Color = Color.valueOf(colorPlayer2);
        
        String size = settingsMap.get("board size");
        String[] sizeParts = size.split("x");
        boardSize = Integer.parseInt(sizeParts[0]);
    }
	/**
	 * function name: getBoardSize
	 * input: void
	 * output: int
	 * operation: return BoardSize
	 */
	public static int getBoardSize() {
		return boardSize;
	}
	/**
	 * function name: getPlayer1Color
	 * input: void
	 * output: Color
	 * operation: return Player1 Color
	 */
	public static Color getPlayer1Color() {
		return player1Color;
	}
	/**
	 * function name: getPlayer2Color
	 * input: void
	 * output: Color
	 * operation: return Player2 Color
	 */
	public static Color getPlayer2Color() {
		return player2Color;
	}
	/**
	 * function name: getFirstPlayer
	 * input: void
	 * output: int
	 * operation: return the first Player's order
	 */
	public static int getFirstPlayer() {
		return firstPlayer;
	}
}
