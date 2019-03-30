package GUI;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MenuController {

    @FXML
    private Button startButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Button closeButton;

    /**
	 * function name: startReversi
	 * input: void
	 * output: void
	 * operation: start a new game
	 */
    @FXML
    private void startReversi() {
        Stage stage = (Stage) startButton.getScene().getWindow();
        SettingData.readSettingsFromFile();
        ReversiController rc = new ReversiController();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation((getClass().getResource("../fxml/ReversiGame.fxml")));
            loader.setController(rc);
            HBox root = (HBox) loader.load();
            Scene scene = new Scene(root, 600, 450);
            scene.getStylesheets().add(getClass().getResource("../fxml/ReversiGame.css").toExternalForm());
            stage.setTitle("Reversi");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    /**
	 * function name: settingGame
	 * input: void
	 * output: void
	 * operation: open setting window
	 */
    @FXML
    protected void settingGame() {
        Settings settings = new Settings();
        Stage stage = (Stage) settingsButton.getScene().getWindow();
        try {
            settings.start(stage);
        } catch (Exception e){
        	System.out.println(e.getMessage());
        }
    }

    
    /**
	 * function name: closeReversi
	 * input: void
	 * output: void
	 * operation: close the window
	 */
    @FXML
    protected void closeReversi() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
