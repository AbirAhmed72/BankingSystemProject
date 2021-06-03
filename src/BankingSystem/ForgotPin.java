package BankingSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ForgotPin {

    @FXML
    private TextField username;
    @FXML
    private TextField mobile;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private Button changePin;
    @FXML
    private Button homePage;
    @FXML
    private Label confirmation;

    public void changePin(ActionEvent event) throws IOException{
        checkInfo();
    }

    private void checkInfo() throws IOException {

        String storedUsername = "";
        String storedPhone = "";

        //System.out.println("storedUsername: " + storedUsername);
        //System.out.println("storedPhone: " + storedPhone);

        try {
            File usernameFile = new File("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\username.txt");
            System.out.println(usernameFile.getAbsolutePath());
            File phoneFile = new File("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\phone.txt");
            System.out.println(phoneFile.getAbsolutePath());

            Scanner usernameScanner = new Scanner(usernameFile);
            Scanner phoneScanner = new Scanner(phoneFile);

            storedUsername = usernameScanner.nextLine();
            storedPhone = phoneScanner.nextLine();

            usernameScanner.close();
            phoneScanner.close();
        } catch (Exception e) {
            System.out.println("Exception caught.");
            e.printStackTrace();
        }

        //System.out.println("storedUsername: " + storedUsername);
        //System.out.println("storedPhone: " + storedPhone);

        if (!username.getText().toString().equals(storedUsername) || !mobile.getText().toString().equals(storedPhone)) {
            confirmation.setText("Username or Mobile do not match!");
            return;
        }

        String password = passwordField.getText().toString();
        String confirmPassword = confirmPasswordField.getText().toString();

        if ((password.length() != 4) || (confirmPassword.length() != 4)){
            confirmation.setText("PIN length should be 4!");
            return;
        }

        if (!password.equals(confirmPassword)) {
            confirmation.setText("PINs do not match!");
            return;
        }

        try {
            FileWriter pinWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\password.txt");
            pinWriter.write("" + password);
            pinWriter.close();
            System.out.println("Successfully wrote to the file.");
            confirmation.setText("PIN changed successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void homePage(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");

    }


}
