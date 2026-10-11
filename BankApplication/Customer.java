package BankApplication;

import javax.naming.InsufficientResourcesException;
import java.util.Scanner;

public class Customer {
    private String name;
    private int accountno;
    private int pin;
    private double balance;
    Customer(String name,int accountno,int pin, double balance){
        this.name = name;
        this.accountno = accountno;
        this.pin = pin;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getAccountno() {
        return accountno;
    }

    public double getBalance() {
        return balance;
    }

    public int getPin() {
        return pin;
    }
    void customerLogin(int accno, int pin) {
        if (accno == accountno && pin == this.pin) {
            System.out.println("\n customer Login Successfully");
            openCustomerMenus();
        } else {
            System.out.println("\n Invalid customer accno or pin");
        }
    }

    void openCustomerMenus() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Customer Menus ------");
            System.out.println("1. Check Balance");
            System.out.println("2.Deposit Money");
            System.out.println("3.Withdraw Money");
            System.out.println("4. Logout");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                   checkBalance();
                    break;
                case 2:
                    System.out.println("\n Enter the amount you want to deposit");
                    double depositedAmt = sc.nextDouble();
                    depositMoney(depositedAmt);
                    break;
                case 3:
                    System.out.println("\n Enter the amount you want to withdraw");
                    double withdrawAmt = sc.nextDouble();
                    withdrawMoney(withdrawAmt);
                    break;
                case 4:
                    System.out.println("\nCustomer logout successfullY");
                    return;
                default:
                    System.out.println("\nInvalid choice! ");
            }
        }
    }

    public void checkBalance(){
        System.out.println("Your Balance: "+getBalance());
    }

    public void depositMoney(double amount){
     if(getBalance() > 0){
         balance+=amount;
         System.out.println("\nAmount deposited successfully, now your balance is Rs. "+getBalance());
     }
     else{
         System.out.println("\nInvalid Amount");
     }
    }

    public void withdrawMoney(double amount){
        if(amount < 0){
            System.out.println("\n Invalid Amount");
        }
       else if(amount > getBalance()) {
            try {
                throw new InsufficientResourcesException("Sorry, Insuffiecient Balance !");
            }
            catch (InsufficientResourcesException e){
                System.out.println("\n"+e.getMessage());
            }
        }
        else{
            balance -= amount;
            System.out.println("Amount withdraw sucessfully, now balance is Rs.  "+getBalance());
        }
    }
}
