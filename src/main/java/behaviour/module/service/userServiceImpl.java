package behaviour.module.service;

import java.util.List;
import behaviour.module.repository.*;
import behaviour.module.model.PostLikeCount;
import behaviour.module.model.UserInfoModel;


public class userServiceImpl  implements userService{
	userRepository userRepo = new userRepositoryImpl();
	
	
	
	public boolean isAddUser(UserInfoModel model) {
		return userRepo.isAddUser(model);
	}
    
public int isgetregisterid(String username,String pass) {
	return userRepo.isgetregisterid(username, pass);
	}

public UserInfoModel isgetAllDatauser(int registerid) {
	return userRepo.isgetAllDatauser(registerid);
}

public boolean UpdateUserData(UserInfoModel model,int rid) {
	return userRepo.UpdateUserData(model, rid);
}
public List isSearchUser(String username) {
	return userRepo.isSearchUser(username);
}
public int gerUserRegistrationid(String username) {
	return userRepo.gerUserRegistrationid(username);
}

public boolean isFollowUser(int userid,int registerid) {
	return userRepo.isFollowUser(userid, registerid);
}
 
public int  getFollowingCount(int registerid) {
	return userRepo.getFollowingCount(registerid);
}

public int  getFollowerCount(int registerid) {
	return userRepo.getFollowerCount(registerid);
}
public List <UserInfoModel>isgetFollowingList(int registerid ) {
	return userRepo.isgetFollowingList(registerid);
}

public List<UserInfoModel> isgetFollowerList(int registerid ) {
	return userRepo.isgetFollowerList(registerid);
	}

public boolean forgetPassward(String oldPass,String newPass,int rid) {
	return userRepo.forgetPassward(oldPass, newPass, rid);
}

public boolean isDeleteAccount(int registerid) {
	return userRepo.isDeleteAccount(registerid);
}
	
public boolean isCheckDeleteReuest(int registerid) {
	return userRepo.isCheckDeleteReuest(registerid);
}
public boolean cancelRequest(int registerid) {
	return userRepo.cancelRequest(registerid);
}

public boolean isRemoveFollower(int registerid,int userid) {
	return userRepo.isRemoveFollower(registerid,userid);
}

@Override
public boolean isUnfollowUser(int registerid, int userid) {
	return userRepo.isUnfollowUser(registerid, userid);
}

@Override
public List<UserInfoModel> isgetAllUsers() {
	return userRepo.isgetAllUsers();
}

@Override
public List<UserInfoModel> isgetAllUsersInfoByName(String name) {
	return userRepo.isgetAllUsersInfoByName(name);
}


		
		
}

