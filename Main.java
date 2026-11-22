package javaapplication6;

import java.util.Scanner;

public class JavaApplication6 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int correctpin = 1234;
        int enterpassword;
        int attempts = 0;
        double balance = 1500;
        int choice;

        String[] transaction = new String[100];
        int transactioncount = 0;

        boolean loggedIn = false;

        System.out.println("WELCOME TO THE ATM");

        while (attempts < 3) {
            System.out.println("enter the pin");
            enterpassword = input.nextInt();
            attempts++;

            if (correctpin == enterpassword) {
                System.out.println("login successful");
                loggedIn = true;
                break;
            } else {
                System.out.println("wrong log in");
            }
        }

        if (!loggedIn) {
            System.out.println("Maximum attempts reached. Card blocked.");
            input.close();
            return;
        }

        do {
            System.out.println("\n--- ATM MAIN MENU ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = input.nextDouble();
                    if (depositAmount > 0) {
                        balance += depositAmount;
                        transaction[transactioncount] = "Deposit: +" + depositAmount + " | Balance: " + balance;
                        transactioncount++;
                        System.out.println("Deposit successful. New Balance: " + balance);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = input.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        transaction[transactioncount] = "Withdraw: -" + withdrawAmount + " | Balance: " + balance;
                        transactioncount++;
                        System.out.println("Withdrawal successful. New Balance: " + balance);
                    } else {
                        System.out.println("Error: Insufficient balance.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Transaction History ---");
                    if (transactioncount == 0) {
                        System.out.println("No transactions yet.");
                    } else {
                        for (int i = 0; i < transactioncount; i++) {
                            System.out.println((i + 1) + ". " + transaction[i]);
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 5);

        input.close();
    }
}
