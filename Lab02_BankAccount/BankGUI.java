import javax.swing.*;
import java.awt.*;

public class BankGUI {
    public static void main(String[] args) {
        // Main window
        JFrame window = new JFrame("Bank Account");
        window.setSize(1000,500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Variables for account creation
        BankAccount account;
        double initialDepositDigit;
        String name, initialDepositString, accountType;
        String[] accountOptions = {"Checking", "Savings"};

        // Name input
        name = JOptionPane.showInputDialog(window, "Enter Your Name: ");
        while (true){
            if (name == null){
                System.exit(0);
            } else if (!name.trim().isEmpty()){
                break;
            } else{
                name = JOptionPane.showInputDialog(window, "Error! Enter a Valid Name:", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Initial deposit input
        initialDepositString = JOptionPane.showInputDialog(window, "Enter Initial Deposit: ");
        while (true){
            try{
                if (initialDepositString == null){
                    throw new NullPointerException();
                } else if (initialDepositString.trim().isEmpty()){
                    throw new NumberFormatException();
                } else{
                    initialDepositDigit = Double.parseDouble(initialDepositString);
                    if (initialDepositDigit < 0){
                        throw new NumberFormatException();
                    }
                }
            break;
            } catch (NumberFormatException e){
                initialDepositString = JOptionPane.showInputDialog(window, "Error! Enter a Valid Number: ", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            } catch (NullPointerException e){
                System.exit(0);
            }
        }
        
        // Account type input
        while (true){
            try{
                accountType = (String) JOptionPane.showInputDialog(window,"Choose Account:", "", JOptionPane.QUESTION_MESSAGE, null, accountOptions, accountOptions[0]);
                if (accountType.equals("Checking")){
                    account = new CheckingAccount(name, initialDepositDigit);
                    break;
                } else if (accountType.equals("Savings")){
                    account = new SavingsAccount(name, initialDepositDigit);
                    break;
                } 
            } catch (NullPointerException e){
                System.exit(0);
            }
        }

        // Setting up menu
        JPanel menu = new JPanel();
        menu.setLayout(new GridLayout(5,1, 5,0));
        window.add(menu, BorderLayout.NORTH);
        JLabel header = new JLabel("Welcome, " + name + "!");
        JLabel balance = new JLabel("Current Balance: $" + String.format("%.2f", initialDepositDigit));
        header.setFont(new Font("Sans Serif", Font.BOLD, 30));
        balance.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        menu.add(header);
        menu.add(balance);

        // User input for deposit/withdrawal
        JPanel inputResize = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel menuOptions = new JLabel("Enter amount to deposit or withdraw:");
        JTextField userInput = new JTextField(10);
        menuOptions.setFont(new Font("Sans Serif", Font.PLAIN, 15));
        inputResize.add(userInput);
        menu.add(menuOptions);
        menu.add(inputResize);

        // Buttons for deposit, withdrawal, and exit
        JPanel buttonPosition = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton deposit = new JButton("Deposit");
        JButton withdraw = new JButton("Withdraw");
        JButton exit = new JButton("Exit");
        buttonPosition.add(deposit);
        buttonPosition.add(withdraw);
        buttonPosition.add(exit);
        menu.add(buttonPosition);


        final BankAccount finalAccount = account;

        // Action listener for deposit button
        deposit.addActionListener(e ->{
            double amountDouble = 0;
            try{
                String amountString = userInput.getText();
                amountDouble = Double.parseDouble(amountString);
                if (amountDouble < 0)
                    throw new NumberFormatException();
                String newBalance = finalAccount.deposit(amountDouble);
                JOptionPane.showMessageDialog(window, newBalance, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                balance.setText("Current Balance: $" + String.format("%.2f", finalAccount.getBalance()));
                userInput.setText("");
            } catch (Exception invalid){
                JOptionPane.showMessageDialog(window, "Invalid response! Try Again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                userInput.setText("");
            } 
        });

        // Action listener for withdraw button
        withdraw.addActionListener(e ->{
            double amountDouble = 0;
            try{
                String amountString = userInput.getText();
                amountDouble = Double.parseDouble(amountString);
                if (amountDouble < 0)
                    throw new NumberFormatException();
                String newBalance = finalAccount.withdraw(amountDouble);
                if (finalAccount.getBalance() < 0)
                    JOptionPane.showMessageDialog(window, newBalance, "Overdraft", JOptionPane.WARNING_MESSAGE);
                else if (newBalance.equals("Transaction Denied: Insufficient funds"))
                    JOptionPane.showMessageDialog(window, newBalance, "Denial", JOptionPane.WARNING_MESSAGE);
                else
                    JOptionPane.showMessageDialog(window, newBalance, "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                balance.setText("Current Balance: $" + String.format("%.2f", finalAccount.getBalance()));
                userInput.setText("");
            } catch (Exception invalid){
                JOptionPane.showMessageDialog(window, "Invalid response! Try Again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                userInput.setText("");
            } 
        });

        // Action listener for exit button
        exit.addActionListener( e ->{
                System.exit(0);
        });

        window.setVisible(true);

    }
}