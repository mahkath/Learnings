package ATM;

public abstract class Bank {
	
	protected String location;
	
	protected Float amountAvailable;
	
	public abstract Money withdraw(float amount, Account debitAccount) throws AuthenticationException, InsufficientFundsException;
	
	public abstract boolean transfer(float amount, Account debitAccount, Account creditAccount) throws AuthenticationException, InsufficientFundsException;
	
	public abstract void deposit(float amount, Account debitAccount) throws AuthenticationException, InsufficientFundsException;
	
	public abstract float checkBalance(Account debitAccount) throws AuthenticationException;
	
	public static  Bank goToBank() {
		return null;
	}
}
