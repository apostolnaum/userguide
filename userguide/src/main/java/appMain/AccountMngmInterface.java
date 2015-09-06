package appMain;



import appMain.Account;
import appMain.CreditCard;

public interface AccountMngmInterface {
	public void createAccount(Account account);

	public Account returnAccount(String email, String password);

	public void deleteAccount(String email);

	public void saveCreditCard(CreditCard card);
}
