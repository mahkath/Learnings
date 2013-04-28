package ATM;

public final class BankBranch extends Bank {

	private static Bank branch = new BankBranch();
	
	private BankBranch() {
	}
	
	public static Bank goToBank() {
		//Can have multiple ATM's. Assuming there is only 1 ATM
		return branch;
	}
	
	@Override
	public Money withdraw(float amount, Account debitAccount) throws AuthenticationException, InsufficientFundsException{
		debitAccount.withdraw(amount);
		return null;
	}

	@Override
	public boolean transfer(float amount, Account debitAccount,
			Account creditAccount) throws AuthenticationException, InsufficientFundsException{
		debitAccount.transfer(amount, creditAccount);
		return false;
	}

	@Override
	public void deposit(float amount, Account debitAccount) throws AuthenticationException, InsufficientFundsException{
		debitAccount.deposit(amount);
	}

	@Override
	public float checkBalance(Account debitAccount) throws AuthenticationException{
		debitAccount.checkBalance();
		return 0;
	}
}
