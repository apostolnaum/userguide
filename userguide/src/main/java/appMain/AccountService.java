package appMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AccountService implements AccountMngmInterface {

	AccountManagementImpl accountRepo;

	@Autowired
	public AccountService(AccountManagementImpl accountRepo) {
		super();
		this.accountRepo = accountRepo;
	}

	@Override
	public void createAccount(Account account) {
		accountRepo.createAccount(account);

	}

	@Override
	public Account returnAccount(String email, String password) {
		Account account = accountRepo.returnAccount(email, password);
		return account;
	}

	@Override
	public void deleteAccount(String email) {
		accountRepo.deleteAccount(email);

	}

	@Override
	public void saveCreditCard(CreditCard card) {
		accountRepo.saveCreditCard(card);

	}

}
