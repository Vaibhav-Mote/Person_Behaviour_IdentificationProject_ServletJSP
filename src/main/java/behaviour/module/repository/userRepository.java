package behaviour.module.repository;

import java.util.List;
import behaviour.module.repository.*;
import behaviour.module.model.UserInfoModel;

public interface userRepository {
	
	userRepository userRepo=new userRepositoryImpl();
	public boolean isAddUser(UserInfoModel model) ;
    
public int isgetregisterid(String username,String pass) ;

public UserInfoModel isgetAllDatauser(int registerid) ;
public boolean UpdateUserData(UserInfoModel model,int rid) ;
public List isSearchUser(String username) ;
public int gerUserRegistrationid(String username) ;

public boolean isFollowUser(int userid,int registerid) ;
public int  getFollowingCount(int registerid) ;
public int  getFollowerCount(int registerid) ;
public List <UserInfoModel>isgetFollowingList(int registerid );

public List<UserInfoModel> isgetFollowerList(int registerid ) ;

public boolean forgetPassward(String oldPass,String newPass,int rid);

public boolean isDeleteAccount(int registerid) ;
public boolean isCheckDeleteReuest(int registerid) ;
public boolean cancelRequest(int registerid) ;
public boolean isRemoveFollower(int registerid,int userid) ;
public boolean isUnfollowUser(int registerid,int userid) ;
public List<UserInfoModel> isgetAllUsers();
public List<UserInfoModel> isgetAllUsersInfoByName(String name);
}
