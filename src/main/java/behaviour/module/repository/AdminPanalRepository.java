package behaviour.module.repository;

import java.util.List;

import behaviour.module.model.UserInfoModel;
import behaviour.module.repository.*;

public interface AdminPanalRepository {
	AdminPanalRepository adminRepo=new AdminPanalRepositoryImpl();
	
	public List ischeckDeleteRequest() ;
	public boolean deleteUserAccount();
	public List<UserInfoModel> viewAllUser() ;

}
