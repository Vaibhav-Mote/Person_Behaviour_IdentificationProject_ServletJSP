package behaviour.module.service;

import java.util.List;

import behaviour.module.model.UserInfoModel;
import behaviour.module.repository.*;
public class AdminPanalSeriviceImpl implements AdminPanalSercvice {
AdminPanalRepository adminRepo=new AdminPanalRepositoryImpl();
	
	public List ischeckDeleteRequest() {
		return adminRepo.ischeckDeleteRequest();
	}
	public boolean deleteUserAccount(){
		return adminRepo.deleteUserAccount();	
	}
	public List<UserInfoModel> viewAllUser() {
		return adminRepo.viewAllUser();
	}
}
