package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;

public class Menu extends Application {

    @Override
        public void start(Stage primaryStage) {
            try {
            	FXMLLoader loader = new FXMLLoader();
            	loader.setLocation((getClass().getResource("../fxml/Menu.fxml")));
            	loader.setController(new MenuController());
            	GridPane root = (GridPane) loader.load();
                Scene scene = new Scene(root,600,450);
                scene.getStylesheets().add(getClass().getResource("../fxml/Menu.css").toExternalForm());
                primaryStage.setTitle("Reversi Game");
                primaryStage.setScene(scene);
                primaryStage.show();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        public static void main(String[] args) {
            launch(args);
        }
    }
