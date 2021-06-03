package BankingSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class AfterLogin implements Initializable {

    @FXML
    public Button logout;
    @FXML
    public Button replacePin;
    @FXML
    public Button transactMoney;
    @FXML
    public Label amountLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        int amount = 0;
        System.out.println("amount: " + amount);
        try {
            File amountFile = new File("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\amount.txt");
            System.out.println(amountFile.getAbsolutePath());

            Scanner amountScanner = new Scanner(amountFile);

            amount = amountScanner.nextInt();
            amountLabel.setText("TK. " + amount);

            amountScanner.close();

        }catch(Exception e){
            System.out.println("Exception caught.");
            e.printStackTrace();
        }
        System.out.println("amount: " + amount);
    }

    public void userLogOut(ActionEvent event) throws IOException {
        Main m = new Main();
        m.changeScene("loginPage.fxml");

    }

    public void transactMoney(ActionEvent event) throws IOException {
        Main n = new Main();
        n.changeScene("transaction.fxml");

    }


    public void replacePin(ActionEvent event) throws IOException {
        Main o = new Main();

        o.changeScene("forgotPin.fxml");

    }
}