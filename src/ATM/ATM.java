package ATM;

public final class ATM extends Bank {
	
	private static Bank atm = new ATM();
	
	private ATM() {
	}
	
	public static Bank goToBank() {
		//Can have multiple ATM's. Assuming there is only 1 ATM
		return atm;
	}
	
	@Override
	public Money withdraw(float amount, Account debitAccount) throws AuthenticationException, InsufficientFundsException{
		debitAccount.withdraw(amount);
		return null;
	}

	@Override
	public boolean transfer(float amount, Account debitAccount,
			Account creditAccount) throws AuthenticationException, InsufficientFundsException {
		debitAccount.transfer(amount, creditAccount);
		return false;
	}

	@Override
	public void deposit(float amount, Account debitAccount) throws AuthenticationException {
		debitAccount.deposit(amount);
	}

	@Override
	public float checkBalance(Account debitAccount) throws AuthenticationException {
		return debitAccount.checkBalance();
	}
}
