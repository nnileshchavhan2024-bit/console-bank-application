package BankApplication;

import java.util.Scanner;

public class Validations {
    public static int  getIntFromUser(Scanner sc) {
        while (true) {
            try {
                return sc.nextInt();
            } catch (Exception e) {
                System.out.println("\n Invalid Input, Enter Valid Number Again !");
                sc.nextLine();
            }
        }
    }
}
