package idata1002;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {root = FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));

            primaryStage.setTitle("Poker Game");
            primaryStage.setScene(new Scene(root, 600, 300));
            primaryStage.show();


        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        launch();
    }

}