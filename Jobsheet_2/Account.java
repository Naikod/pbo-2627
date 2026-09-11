package Jobsheet_2;

public class Account {
    public String ownerName;
    public double balance;

    public Account(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        if(isOverdrawn()) {
            balance += amount;
            System.out.println("Warning: Insufficient balance!");
        }

    }

    public void printInfo() {
        System.out.println(ownerName + " - Balance: " + balance);
    }

    public String formatBalance() {
        return String.format("%,.2f", balance);
    }

    public Boolean isOverdrawn() {
        return balance < 0;
    }

    public void transferTo(Account to, double amount) {
        if(balance >= amount) {
            this.withdraw(amount);
            to.deposit(amount);
        } else {
            System.out.println("Transfer failed: Insufficient balance.");
        }
    }

}
