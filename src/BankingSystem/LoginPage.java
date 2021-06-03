package BankingSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LoginPage {

    @FXML
    private Button getStarted;
    @FXML
    private Label wrongLogIn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button forgotPassword;



    public void userLogIn(ActionEvent event) throws IOException {
        checkLogin();

    }

    private void checkLogin() throws IOException {
        Main m = new Main();

        String storedUsername = "";
        String storedPassword = "";

        //System.out.println("storedUsername: " + storedUsername);
        //System.out.println("storedPassword: " + storedPassword);

        try {
            File usernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\username.txt");
            System.out.println(usernameFile.getAbsolutePath());
            File passwordFile = new File("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\password.txt");
            System.out.println(passwordFile.getAbsolutePath());

            Scanner usernameScanner = new Scanner(usernameFile);
            Scanner passwordScanner = new Scanner(passwordFile);

            storedUsername = usernameScanner.nextLine();
            storedPassword = passwordScanner.nextLine();

            usernameScanner.close();
            passwordScanner.close();
        }catch(Exception e){
            System.out.println("Exception caught.");
            e.printStackTrace();
        }

        //System.out.println("storedUsername: " + storedUsername);
        //System.out.println("storedPassword: " + storedPassword);

        if(username.getText().toString().equals(storedUsername) && password.getText().toString().equals(storedPassword)) {
            wrongLogIn.setText("Success!");

            m.changeScene("afterLogin.fxml");
        }

        else if(username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogIn.setText("Please enter your data.");
        }

        else {
            wrongLogIn.setText("Wrong username or password!");
        }
    }

    public void forgotPassword(ActionEvent event) throws IOException {
        Main n = new Main();

        n.changeScene("forgotPin.fxml");

    }


}