public abstract class BankAccount{
    private String accountHolder;
    private double balance;

    //constructor
    public BankAccount(String accountHolder, double balance){
        this.accountHolder = accountHolder;
        this.balance = balance;
    }
    
    //setters
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAccountHolder(String accountHolder){
        this.accountHolder = accountHolder;
    }

    //getters
    public double getBalance(){
        return balance;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    //adds money into balance
    public String deposit(double amount) {
        balance += amount;
        return "New Balance: $" + String.format("%.2f", balance);
    }

    //subtract money from account
    abstract public String withdraw(double amount);
}
