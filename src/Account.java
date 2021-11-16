import javax.crypto.spec.PSource;
import javax.swing.*;
import java.util.Scanner;

/*
Account class w
 */
public class Account {
    float balance;
    float recentTransaction;
    String firstName;
    String lastName;
    String customerName;
    int customerID = 10001;
    String accountID;

    // constructor asking for new account holder

    public Account() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome! Please enter the customer's first name: ");
        this.firstName = in.nextLine();

        System.out.println("Please enter the customer's Last name");
        this.lastName = in.nextLine();

        SetCustomerID();
        System.out.println("Welcome " + firstName + " " + lastName + "\nYour account ID is " + accountID);

        showMenu();
    }

    public void SetCustomerID(){
        customerID++;
        this.accountID = "MB" + customerID;

    }

    // to deposit money
    void deposit(float amount) {
        if(amount != 0) {
            balance = balance + amount;
            recentTransaction = amount;
        }
    }

    /// to withdraw money
    void withdraw(float amount){
        if(amount != 0) {
            balance = balance - amount;
            recentTransaction = -amount;
        }
    }

    // to check balance
    public float checkBalance(){
        return balance;
    }

    // for most recent transaction
    void getRecentTransaction(){
        if(recentTransaction < 0) {
            System.out.println("There was a withdrawal of: £" + recentTransaction);
        } else if(recentTransaction > 0) {
            System.out.println("There was a deposit of: £" + recentTransaction);
        } else {
            System.out.println("There have been no transactions");
        }
    }

    void calculateInterest(int years) {
        double interestRate = 0.0125;
        double newBalance = (balance + interestRate + years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate));
        System.out.println("After " + years + "years, your current balance will be: " + newBalance);
    }

    void showMenu() {
        char item = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("How would you like to proceed?");
        System.out.println("A. Check your balance \nB. Make a deposit \nC. Withdraw some money \nD. View most recent transaction \nE. Calculate interest on current balance \nF. EXIT");

        do {
            System.out.println("Enter the letter option below: ");
            char item1 = scanner.next().charAt(0);
            item = Character.toUpperCase(item1);        // in case user enters a lower case char

            switch(item) {
                case 'A' :
                    System.out.println("Account Balance is: £" + balance);
                    break;
                case 'B':
                    System.out.print("Please enter an amount to deposit: £");
                    float amount = scanner.nextFloat();
                    deposit(amount);
                    System.out.println("You have deposited £" + amount);
                    System.out.println("New account balance £" + balance);
                    break;

                case 'C':
                    System.out.print("Please enter an amount to withdraw: £");
                    float amount2 = scanner.nextFloat();
                    withdraw(amount2);
                    System.out.println("You have withdrawn £" + amount2);
                    System.out.println("New account balance is £ " + balance);
                    break;

                case 'D':
                   getRecentTransaction();
                   System.out.println(recentTransaction);
                   break;

                case 'E':
                    System.out.println("Enter how many years interest accrued");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;

                case 'F':
                    System.out.println();
                    break;

                default:
                    System.out.println("Error! Invalid option selected- please enter A, B, C, D, E, or F");
                    break;
            }

        } while (item != 'F');
        System.out.println("Thank you for banking with us. Have a good day!");
    }

}
