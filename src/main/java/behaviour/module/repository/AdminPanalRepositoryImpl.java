package behaviour.module.repository;

import java.util.ArrayList;
import java.util.List;

import behaviour.config.DBParent;
import behaviour.module.model.UserInfoModel;


public class AdminPanalRepositoryImpl extends DBParent implements AdminPanalRepository {

	//check Delete request
	public List ischeckDeleteRequest() {
		try {
			List list=new ArrayList();
			stmt=conn.prepareStatement("select *from deleterequest");
			rs=stmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt(1));
			}
			return list.size()>0?list:null;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
	//delete all user account requested for Admin
	public boolean deleteUserAccount(){
		List <Integer>list=new ArrayList();
		list=this.ischeckDeleteRequest();
		if(list.size()>0) {
			try {
				int flag=0;
				for(Integer m:list) {
					stmt=conn.prepareStatement("delete from userregistrationmaster where registerid=?");
					stmt.setInt(1, m);
					int v=stmt.executeUpdate();
					if(v>0) {
						flag=1;
					}else {
						flag=0;
						break;
					}
				}
				return flag!=0?true:false;
	
			}catch(Exception ex) {
				return false;
			}
		}
		return false;
	}
	
	//view all user
	public List<UserInfoModel> viewAllUser() {
		try {
			List <UserInfoModel> list=new ArrayList();
            stmt=conn.prepareStatement("select *from userregistrationmaster");
			rs=stmt.executeQuery();
			UserInfoModel userInfoModel;
			while(rs.next()) {
				userInfoModel=new UserInfoModel();
				userInfoModel.setName(rs.getString(2));
				userInfoModel.setEmail(rs.getString(3));
				userInfoModel.setUsername(rs.getString(4));
				userInfoModel.setPass(rs.getString(5));
				list.add(userInfoModel);
						}
			return list.size()>0?list:null;
			
		}catch(Exception ex) {
			return null;
		}
	}
	
}
