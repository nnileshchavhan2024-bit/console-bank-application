package BankApplication;

public class InsufficientBalanceException extends RuntimeException{
    InsufficientBalanceException(){
        super();
    }
    InsufficientBalanceException(String message){
        super(message);
    }
}

