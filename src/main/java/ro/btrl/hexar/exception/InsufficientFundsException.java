package ro.btrl.hexar.exception;

public class InsufficientFundsException extends Exception {

    public InsufficientFundsException(String insufficientFunds) {
        super(insufficientFunds);
    }
}
