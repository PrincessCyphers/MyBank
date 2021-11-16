import javax.crypto.spec.PSource;
import java.util.Scanner;

/*
Account class w
 */
public class Account {
    int balance;
    int recentTransaction;
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
    }

    public void SetCustomerID(){
        customerID++;
        this.accountID = "MB" + customerID;

    }

    // to deposit money
    void deposit(int amount) {
        if(amount != 0) {
            balance = balance + amount;
            recentTransaction = amount;
        }
    }

    /// to withdraw money
    void withdraw(int amount){
        if(amount != 0) {
            balance = balance - amount;
            recentTransaction = -amount;
        }
    }

    // to check balance
    public int checkBalance(){
        return balance;
    }

    // for most recent transaction
    void getRecentTransaction(){
        if(recentTransaction < 0) {
            System.out.println("There was a deposit of: £" + recentTransaction);
        } else if(recentTransaction > 0) {
            System.out.println("There was a withdrawal of: £" + recentTransaction);
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
        System.out.println("How would you like to proceed? Enter the letter option below");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Withdraw some money");
        System.out.println("D. View most recent transaction");
        System.out.println("E. Calculate interest on current balance");
        System.out.println("F. EXIT");

        do {
            System.out.println();
        }
    }

}
