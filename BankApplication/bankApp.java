package BankApplication;

import java.util.Scanner;

public class bankApp {
    Scanner sc;
    Admin admin;
    Customer customer;
    bankApp() {
        sc = new Scanner(System.in);
        admin = new Admin(sc);
    }

    private final String adminEmail = "admin@gmail.com";
    private final String adminPass = "admin123";

    static void main() {
        bankApp b = new bankApp();
        b.startBankApp();
    }

    void startBankApp() {

        System.out.println("===== Welcome to bank App ====");

        while (true) {
            System.out.println("\nPlease select any one option");
            System.out.println("1. Admin Login");
            System.out.println("2. Customer Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n Enter Admin Email Id: ");
                    String email = sc.next();

                    System.out.println("\n Enter Admin Password: ");
                    String pass = sc.next();

                    adminLogin(email, pass);

                    break;
                case 2:
                    if(customer != null) {
                        System.out.println("\n Enter Customer Account NO: ");
                        int accno = Validations.getIntFromUser(sc);

                        System.out.println("\n Enter Customer Pin NO: ");
                        int pin = Validations.getIntFromUser(sc);

                        customer.customerLogin(accno, pin);
                    }
                    else{
                        System.out.println("No customer Exists, Please contact Admin! ");
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using Bank App");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice \n");
            }
        }
    }

    void adminLogin(String email, String pass) {
        if (email.equals(adminEmail) && pass.equals((adminPass))) {
            System.out.println("\n Admin Login Successfully");
            openAdminMenus();
        } else {
            System.out.println("\n Invalid Admin Email Id Or Password");
        }
    }

    void openAdminMenus() {
        while (true) {
            System.out.println("\n----- Admin Menu ------");
            System.out.println("1. Open Customer Account");
            System.out.println("2. Close Customer Account");
            System.out.println("3. View Customer Account");
            System.out.println("4. Logout");

            int choice = Validations.getIntFromUser(sc);

            switch (choice) {
                case 1:
                  if(customer != null){
                      System.out.println("Customer already exists, please close the previous customer account");
                  }
                  else{
                      customer = admin.createCustomerAccount();
                  }
                    break;
                case 2:
                    if(customer != null) {
                        System.out.println("Enter Customer Account NO: ");
                      int accountno = Validations.getIntFromUser(sc);
                      if(accountno == customer.getAccountno()){
                          customer = null;
                          System.out.println("\n Customer Account Closed Successfully");
                      }
                      else{
                          System.out.println("\n Invalid Customer Account NO. !");
                      }
                    }
                    else{
                        System.out.println("\n Customer does not exists !");
                    }
                    break;
                case 3:
                    if(customer != null){
                        System.out.println("\n Enter customer account no: ");
                        int accountno = Validations.getIntFromUser(sc);

                        if(accountno == customer.getAccountno()){
                            System.out.println("\n-------Customer details--------");
                            System.out.println("Customer Name: "+customer.getName());
                            System.out.println("Customer Account NO: "+customer.getAccountno());
                            System.out.println("Customer Balance: "+customer.getBalance());
                        }
                      else{
                            System.out.println("\nInvalid customer account no !");
                        }
                    }
                    else{
                        System.out.println("\n Customer does not exists");
                    }
                    break;
                case 4:
                    System.out.println("\nAdmin logout successfullY");
                    return;
                default:
                    System.out.println("\nInvalid choice! ");
            }
        }
    }


    }

