package BankingSystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage stg;

    @Override
    public void start(Stage primaryStage) throws Exception{
        stg = primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(getClass().getResource("loginPage.fxml"));
        //Image icon = new Image("/Images/HelloBank-Logo (2).png");
        //primaryStage.getIcons().add(new Image("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\src\\Images\\HelloBank-Logo (2).png"));
        primaryStage.setTitle("Welcome to Hello Bank");
        primaryStage.setScene(new Scene(root, 600, 400, Color.BLACK));
        primaryStage.show();

    }

    public void changeScene(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }


    public static void main(String[] args) {
        launch(args);
    }
}