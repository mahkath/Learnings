package ATM;

public final class SavingAccount extends Account {

	public SavingAccount(double initialDeposit) {
		amount = new Double(initialDeposit);
		accountNumber = 123;
	}
	
	private boolean authenticate() {
		return true;
	}
	
	@Override
	public boolean withdraw(double amountToWithdraw) throws InsufficientFundsException{
		authenticate();
		return false;
	}

	@Override
	public boolean transfer(double amountToTransfer, Account creditTo) throws InsufficientFundsException {
		authenticate();
		return false;
	}

	@Override
	public float checkBalance() {
		authenticate();
		return 0;
	}

	@Override
	public boolean deposit(double amountToDeposit) {
		authenticate();
		return false;
	}

}
