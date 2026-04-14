public class SavingsAccount extends BankAccount{
    //constructor
    public SavingsAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }

    //subtract money from account if necessary
    @Override
    public String withdraw(double amount){
        if (amount > getBalance())
            return "Transaction Denied: Insufficient funds";
        else{
            setBalance(getBalance() - amount);
            return "New Balance: $" + String.format("%.2f", getBalance());
        }
    }
}