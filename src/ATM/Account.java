package ATM;

public abstract class Account {
	
	protected int accountNumber;
	
	private String pin;
	
	private String username;
	
	private String password;
	
	protected Double amount;
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public Account() {
		//Generate Account number
	}
	
	public String getPin() {
		return pin;
	}
	
	public abstract boolean withdraw(double amount) throws InsufficientFundsException;
	
	public abstract boolean transfer(double amount, Account creditTo) throws InsufficientFundsException;
	
	public abstract float checkBalance();
	
	public abstract boolean deposit(double amount);
	
	protected boolean authenticate(String pin) {
		return true;
	}
	
	protected boolean authenticate(String username, String password) {
		return true;
	}

}
