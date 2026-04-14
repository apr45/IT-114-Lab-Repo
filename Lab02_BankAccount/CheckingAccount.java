public class CheckingAccount extends BankAccount{
    //constructor
    public CheckingAccount(String accountHolder, double balance){
        super(accountHolder, balance);
    }

    //subtract money from account; imposes fees if necessary
    @Override
    public String withdraw(double amount){
        double overdraftFee = 35.00;
        double newBalance = getBalance() - amount;

        //checks for overdraft
        if (amount > getBalance()){
            newBalance -= overdraftFee;
            setBalance(newBalance);
            return "Overdraft! $35.00 fee applied. New Balance: $-" + String.format("%.2f", getBalance() * -1);
        } else{
            setBalance(newBalance);
            return "New Balance: $" + String.format("%.2f", getBalance());
        }
    }
}