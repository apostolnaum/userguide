package appMain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService implements AdminInterface {

	AdminMngImpl adminRepo;
	
	@Autowired
	public AdminService(AdminMngImpl adminRepo) {
		super();
		this.adminRepo = adminRepo;
	}


	@Override
	public Admin returnAdmin(String username, String password) {
		Admin returnAdmin = adminRepo.returnAdmin(username, password);
		return returnAdmin;
	}

	

}
