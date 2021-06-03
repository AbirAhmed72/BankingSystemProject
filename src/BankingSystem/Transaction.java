package BankingSystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Transaction {

    @FXML
    private TextField amount;
    @FXML
    private TextField phone;
    @FXML
    private TextField ATM;
    @FXML
    private Label successText;
    @FXML
    private Label errorText;
    @FXML
    private Button sendMoney;
    @FXML
    private Button withdrawMoney;
    @FXML
    private Button toAfterLogin;

    public void sendMoney(ActionEvent event) throws IOException{
        Main m = new Main();
        if(amount.getText().isEmpty() || phone.getText().isEmpty()){
            errorAlert("Enter both amount and phone number!");
        }
        else{
            int storedAmount = readAmount();
            System.out.println("storedAmount: " + storedAmount);

            int deductAmount = Integer.parseInt(amount.getText());
            System.out.println("deductAmount: " + deductAmount);

            if (storedAmount < deductAmount) {
                errorAlert("Insufficient Balance!");
                return;
            }

            storedAmount -= deductAmount;
            System.out.println("storedAmount: " + storedAmount);

            writeAmount(storedAmount);

            successAlert("Money sent successfully!");
        }
    }

    public void withdrawMoney(ActionEvent event) throws IOException{
        Main n = new Main();
        if(amount.getText().isEmpty() || ATM.getText().isEmpty()){
            errorAlert("Enter both amount and ATM code!");
        }
        else{
            int storedAmount = readAmount();
            System.out.println("storedAmount: " + storedAmount);

            int deductAmount = Integer.parseInt(amount.getText());
            System.out.println("deductAmount: " + deductAmount);

            if (storedAmount < deductAmount) {
                errorAlert("Insufficient Balance!");
                return;
            }

            storedAmount -= deductAmount;
            System.out.println("storedAmount: " + storedAmount);

            writeAmount(storedAmount);

            successAlert("Money withdrawn successfully!");
        }
    }

    public void toAfterLogin(ActionEvent event) throws IOException{
        Main o = new Main();
        o.changeScene("afterLogin.fxml");
    }

    public int readAmount(){
        int amount = 0;
        System.out.println("amount: " + amount);
        try {
            File amountFile = new File("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\amount.txt");
            System.out.println(amountFile.getAbsolutePath());

            Scanner amountScanner = new Scanner(amountFile);

            amount = amountScanner.nextInt();


            amountScanner.close();

        }catch(Exception e){
            System.out.println("Exception caught.");
            e.printStackTrace();
        }
        System.out.println("amount: " + amount);

        return amount;
    }

    public void writeAmount(int amount){
        try {
            FileWriter amountWriter = new FileWriter("C:\\Users\\Admin\\IdeaProjects\\BankingPracttice\\Files\\amount.txt");
            amountWriter.write("" + amount);
            amountWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void successAlert(String message){
        errorText.setText("");
        successText.setText(message);
    }

    public void errorAlert(String message){
        successText.setText("");
        errorText.setText(message);
    }
}
