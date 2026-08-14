 import java.util.Scanner;

// Class representing the user's bank account
class BankAccount {

    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Withdraw money
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance!");
            return false;
        }

        balance -= amount;

        System.out.println("Withdrawal successful!");
        System.out.println("Amount withdrawn: Rs. " + amount);

        return true;
    }

    // Deposit money
    public boolean deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid amount!");
            return false;
        }

        balance += amount;

        System.out.println("Deposit successful!");
        System.out.println("Amount deposited: Rs. " + amount);

        return true;
    }

    // Check balance
    public double getBalance() {
        return balance;
    }
}


// Class representing the ATM machine
class ATM {

    private BankAccount account;

    // Connect ATM with Bank Account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Withdraw option
    public void withdraw(double amount) {
        account.withdraw(amount);
    }

    // Deposit option
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Check balance option
    public void checkBalance() {
        System.out.println("Current Balance: Rs. " + account.getBalance());
    }
}


// Main class
public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create bank account with initial balance
        BankAccount account = new BankAccount(10000);

        // Connect ATM with account
        ATM atm = new ATM(account);

        int choice;

        System.out.println("=================================");
        System.out.println("        WELCOME TO ATM");
        System.out.println("=================================");

        do {

            // ATM Menu
            System.out.println("\n--------- ATM MENU ---------");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.println("----------------------------");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    // Check balance
                    atm.checkBalance();
                    break;

                case 2:
                    // Deposit money
                    System.out.print("Enter amount to deposit: Rs. ");
                    double depositAmount = sc.nextDouble();

                    atm.deposit(depositAmount);
                    break;

                case 3:
                    // Withdraw money
                    System.out.print("Enter amount to withdraw: Rs. ");
                    double withdrawAmount = sc.nextDouble();

                    atm.withdraw(withdrawAmount);
                    break;

                case 4:
                    System.out.println("\nThank you for using our ATM!");
                    System.out.println("Please collect your card.");
                    break;

                default:
                    System.out.println("Invalid choice!");
                    System.out.println("Please select an option from 1 to 4.");
            }

        } while (choice != 4);

        sc.close();
    }
}