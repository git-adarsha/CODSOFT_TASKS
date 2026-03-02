import java.util.*;

class Account {
    int balance;

    public Account(int balance) {
        this.balance = balance;
    }
}

public class ATM {
    private Account account;

    public ATM(Account account) {
        this.account = account;
    }

    public void withdraw(int amount) {
        if (amount > account.balance) {
            System.out.println("Insufficient funds!");
        } else {
            account.balance -= amount;
            System.out.println("Withdraw successful! New balance: " + account.balance);
        }
    }

    public void deposit(int depAmount) {
        if (depAmount > 0) {
            account.balance += depAmount;
            System.out.println("Deposit successful. New balance: " + account.balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void checkBalance() {
        System.out.println("Current Balance: " + account.balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account account = new Account(1000);
        ATM atm = new ATM(account);
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Exit");

        while(true) {
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    int amount = sc.nextInt();
                    atm.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Enter amount to deposit");
                    int deposit = sc.nextInt();
                    atm.deposit(deposit);
                    break;
                case 4:
                    System.out.println("Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }

    }
}