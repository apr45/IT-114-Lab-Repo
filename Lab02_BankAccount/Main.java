/*import java.util.*;
public class Main{
    public static void main(String[] args){
        
            Scanner scan = new Scanner(System.in);

            //ask for name
            System.out.print("Please enter your name: ");
            String name = scan.nextLine();

            //ask for deposit
            System.out.print("Initial Deposit for your account: ");
            double initialDeposit = scan.nextDouble();
            scan.nextLine();

            //sets up a bank account
            BankAccount account;
            String choice;
            while (true){
                System.out.print("\nChoose Account:\n1. Checking\n2. Savings\nChoice: ");
                choice = scan.nextLine();
                if (choice.equals("1")){
                    account = new CheckingAccount(name, initialDeposit);
                    break;
                } else if (choice.equals("2")){
                    account = new SavingsAccount(name, initialDeposit);
                    break;
                } else
                    System.out.println("Invalid response! Try again.");
            }
        
            //MENU
            while (true){
                System.out.print("\n---MENU---\n1. Deposit\n2. Withdraw\n3. View Balance\n4. Exit\nChoice: ");
                choice = scan.nextLine();
            
                if (choice.equals("1")){
                    System.out.print("Amount to deposit: ");
                    double depositAmount = 0;
                    while (depositAmount <= 0){
                    try{
                        depositAmount = scan.nextDouble();
                        account.deposit(depositAmount);
                    } catch (InputMismatchException e){
                        account.deposit(0);
                    }
                    scan.nextLine();
                    }
                } else if (choice.equals("2")){
                    System.out.print("Amount to withdraw: ");
                    double withdrawAmount = 0;
                    while (withdrawAmount <= 0){
                    try{
                        withdrawAmount = scan.nextDouble();
                        account.withdraw(withdrawAmount);
                    } catch (InputMismatchException e){
                        account.withdraw(0);
                    }
                    scan.nextLine();
                    }
                } else if (choice.equals("3")){
                    if (account.getBalance() < 0)
                        System.out.printf("New Balance: -$%.2f%n", (account.getBalance() * -1));
                    else
                        System.out.printf("New Balance: $%.2f%n", account.getBalance());
                } else if (choice.equals("4")){
                    System.out.print("Goodbye.");
                    break;
                } else
                    System.out.println("Invalid response! Try again.");
            }

            scan.close();
       
    }
}
    */