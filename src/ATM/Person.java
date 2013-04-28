package ATM;

public class Person {
	private Account mySavingAccount = new SavingAccount(100);
	public void needCash() {
		Bank atm = ATM.goToBank();
		try {
			atm.withdraw(100, mySavingAccount);
		} catch (AuthenticationException e) {
			e.printStackTrace();
		} catch (InsufficientFundsException e) {
			e.printStackTrace();
		}
	}
}
