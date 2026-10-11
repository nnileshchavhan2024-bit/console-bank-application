package BankApplication;

import java.util.Scanner;

public class Admin {
    Scanner sc;
    Admin(Scanner sc){
        this.sc = sc;
    }
    public Customer createCustomerAccount(){
        System.out.println("\nEnter customer name");
        String name = sc.next();

        System.out.println("Enter customer account no");
        int accountno = sc.nextInt();

        System.out.println("Enter customer pin");
        int pin = sc.nextInt();

        System.out.println("Enter initial balance");
        double balance = sc.nextDouble();

        System.out.println("Customer Account created successfully");
        return new Customer(name,accountno,pin,balance);
    }
}
