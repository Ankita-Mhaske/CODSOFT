import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" Successfully deposited ₹" + amount);
        } else {
            System.out.println(" Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn ₹" + amount);
            return true;
        } else {
            System.out.println(" Insufficient balance or invalid amount!");
            return false;
        }
    }
}

class ATM {
    private BankAccount userAccount;

    public ATM(BankAccount account) {
        this.userAccount = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n ATM Menu:");
            System.out.println("1️)Check Balance");
            System.out.println("2️)Deposit Money");
            System.out.println("3️)Withdraw Money");
            System.out.println("4️)Exit");
            System.out.print("Choose an option: ");

            int choice;
            while (!scanner.hasNextInt()) {
                System.out.print(" Invalid input! Please enter a number: ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println(" Current Balance: ₹" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print(" Enter amount to deposit: ₹");
                    while (!scanner.hasNextDouble()) {
                        System.out.print(" Invalid input! Enter a valid amount: ");
                        scanner.next();
                    }
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print(" Enter amount to withdraw: ₹");
                    while (!scanner.hasNextDouble()) {
                        System.out.print(" Invalid input! Enter a valid amount: ");
                        scanner.next();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println(" Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println(" Invalid option! Please try again.");
            }
        }
        scanner.close();
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(5000); // Initial balance ₹5000
        ATM atm = new ATM(userAccount);
        atm.displayMenu();
    }
}
