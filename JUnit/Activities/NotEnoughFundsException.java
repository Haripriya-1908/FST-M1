package Activity;

public class NotEnoughFundsException extends Exception {
	 public NotEnoughFundsException(Integer amount, Integer balance) {
	        super("Attempted to withdraw " + amount + " with a balance of " + balance);
	    }
}
