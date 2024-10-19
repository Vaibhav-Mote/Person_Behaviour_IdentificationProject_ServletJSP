package behaviour.module.service;

import java.util.List;

import behaviour.module.model.UserInfoModel;
import behaviour.module.repository.*;
public interface AdminPanalSercvice {
	AdminPanalRepository adminRepo=new AdminPanalRepositoryImpl();
	
	public List ischeckDeleteRequest() ;
	public boolean deleteUserAccount();
	public List<UserInfoModel> viewAllUser();
}
