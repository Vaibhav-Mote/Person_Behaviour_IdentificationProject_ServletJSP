package behaviour.module.repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import behaviour.config.DBParent;
import behaviour.module.model.UserInfoModel;

public class userRepositoryImpl extends DBParent implements userRepository {
	

	//add new registration in table
	public boolean isAddUser(UserInfoModel model) {
		
		
		try {
			stmt = conn.prepareStatement("insert into userregistrationmaster value('0',?,?,?,?)");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getUsername());
			stmt.setString(4, model.getPass());
			int a = stmt.executeUpdate();
			return (a > 0) ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return false;
		}
	}

	//get registration id 
	public int isgetregisterid(String username, String pass) {
		try {
			stmt = conn
					.prepareStatement("select registerid from userregistrationmaster where username=? && passward=?");
			stmt.setString(1, username);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return -1;
		}
	}

	//get All data for user
	public UserInfoModel isgetAllDatauser(int registerid) {
		UserInfoModel model = new UserInfoModel();
		try {
			stmt = conn.prepareStatement("select *from userregistrationmaster where registerid=?");
			stmt.setInt(1, registerid);
			rs = stmt.executeQuery();
			while (rs.next()) {
				model.setName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setUsername(rs.getString(4));
				model.setPass(rs.getString(5));

			}
			return model;
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return null;
		}
	}

	
	//update user data
	public boolean UpdateUserData(UserInfoModel model, int rid) {
		try {
			stmt = conn
					.prepareStatement("update userregistrationmaster set name=?,email=?,username=? where registerid=?");
			stmt.setString(1, model.getName());
			stmt.setString(2, model.getEmail());
			stmt.setString(3, model.getUsername());
			stmt.setInt(4, rid);
			int v = stmt.executeUpdate();
			return (v > 0) ? true : false;
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return false;
		}
	}
//search the user
	public List<String> isSearchUser(String username) {
		List<String> list = new ArrayList<String>();
		try {
			stmt = conn.prepareStatement("SELECT username FROM userregistrationmaster WHERE username LIKE ?");
			stmt.setString(1, username + "%");
			rs = stmt.executeQuery();
			while (rs.next()) {
				list.add(rs.getString(1));
			}
			return list;

		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return null;
		}

	}
//get user registration id
	public int gerUserRegistrationid(String username) {
		try {
			stmt = conn.prepareStatement("select registerid from userregistrationmaster where username=?");
			stmt.setString(1, username);
			rs = stmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getInt(1));
				return rs.getInt(1);
			} else {
				return -1;
			}
		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return -1;
		}
	}
	
	//follow the another user 
	int oldfollowerid=0,oldfollowingid=0,olduserid=0;
	public boolean isFollowUser(int userid, int registerid) {
		try {
			int followerid;
			int followingid;
			//granted key is return the current data 
			stmt = conn.prepareStatement("insert into followingmaster values('0',?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, userid);
			int g = stmt.executeUpdate();
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				followerid = rs.getInt(1);
				
				if (g > 0) {
					stmt = conn.prepareStatement("insert into followermaster values('0',?)",
							PreparedStatement.RETURN_GENERATED_KEYS);
					stmt.setInt(1, registerid);
					int v = stmt.executeUpdate();
					rs = stmt.getGeneratedKeys();
					if (rs.next()) {
						followingid = rs.getInt(1);
						
						if (v > 0) {
							
							stmt=conn.prepareStatement("select *from followerfollowingjoin where registerid=? and followingid=?");
							stmt.setInt(1,registerid);
							stmt.setInt(2, oldfollowerid);
							rs=stmt.executeQuery();
							
							if(rs.next()) {
								int flowingid=rs.getInt(3);
								stmt=conn.prepareStatement("select *from followerfollowingjoin where registerid=? and followerid=?");
								stmt.setInt(1, userid);
								stmt.setInt(2, oldfollowingid);
								rs=stmt.executeQuery();
								
								if(rs.next()) {
									System.out.println("===>>you are alredy following<<=====");
									System.out.println("1:Unfollow");
									System.out.println("Please 1 For Unfollow");
									Scanner sc=new Scanner(System.in);
									int choice=sc.nextInt();
									switch(choice) {
									case 1:
										stmt=conn.prepareStatement("delete from followerfollowingjoin where registerid=? and followingid=?");
										stmt.setInt(1,registerid);
										stmt.setInt(2, oldfollowerid);
						
										if(stmt.executeUpdate()==1) {
											System.out.println("Unfollowed");
										}else {
											System.out.println("Some problem is there.....");
										}
										
										default:
											System.out.println("wrong choice");
									}
									
								
									return false;
									
								}
								
								else {
									stmt = conn.prepareStatement("insert into followerfollowingjoin (registerid ,followingid)values(?,?)");
									stmt.setInt(1, registerid);
									stmt.setInt(2, followerid);
									stmt.executeUpdate();
									stmt = conn.prepareStatement("insert into followerfollowingjoin (registerid ,followerid)values(?,?)");
									stmt.setInt(1,userid );
									stmt.setInt(2, followingid);
									int value = stmt.executeUpdate();
									if (value > 0) {
										oldfollowerid=followerid;
										oldfollowingid=followingid;
										olduserid=userid;
										
										return true;
									} 
									else {
										return false;
									}
									
								}
							}else {
				
								stmt = conn.prepareStatement("insert into followerfollowingjoin (registerid ,followingid)values(?,?)");
								stmt.setInt(1, registerid);
								stmt.setInt(2, followerid);
								stmt.executeUpdate();
								stmt = conn.prepareStatement("insert into followerfollowingjoin (registerid ,followerid)values(?,?)");
								stmt.setInt(1,userid );
								stmt.setInt(2, followingid);
								int value = stmt.executeUpdate();
								if (value > 0) {
									oldfollowerid=followerid;
									oldfollowingid=followingid;
									olduserid=userid;
									
									return true;
								} 
								else {
									return false;
								}
							}
							
							

						} else {
							return false;
						}
					}
					else {
						return false;
					}

				} else {
					return false;
				}
			} 
			else {
				return false;
			}

		} catch (Exception ex) {
			System.out.println("Error is:" + ex);
			return false;

		}
	}
	
	//get following count 
	public int  getFollowingCount(int registerid) {
		try {
			stmt=conn.prepareStatement("select count(ff.followingid) from userregistrationmaster r inner join followingmaster fwing on r.registerid=fwing.registerid inner join followerfollowingjoin ff on fwing.followingid=ff.followingid group by ff.registerid having ff.registerid=?");
		    stmt.setInt(1, registerid);
		    rs=stmt.executeQuery();
		    if(rs.next()) {
		    	return rs.getInt(1);
		    }
		    else {
		    	return 0;
		    }
		
		}catch(Exception ex) {
			System.out.println("Error is:"+ex);
			return 0;
		}
		
		
	}
	
	
	//get follower count
	public int  getFollowerCount(int registerid) {
		try {
			stmt=conn.prepareStatement("select count(ff.followerid) from userregistrationmaster r inner join followermaster fwer on r.registerid=fwer.registerid inner join followerfollowingjoin ff on fwer.followerid=ff.followerid group by ff.registerid having ff.registerid=?");
		    stmt.setInt(1, registerid);
		    rs=stmt.executeQuery();
		    if(rs.next()) {
		    	return rs.getInt(1);
		    }
		    else {
		    	return 0;
		    }
		
		}catch(Exception ex) {
			System.out.println("Error is:"+ex);
			return 0;
		}
		
		
	}
	//get follower list
	public List<UserInfoModel> isgetFollowerList(int registerid ) {
		List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		try {
			stmt=conn.prepareStatement("select r.registerid ,r.name,r.username from userregistrationmaster r inner join followermaster fwer on r.registerid=fwer.registerid inner join followerfollowingjoin ff on fwer.followerid=ff.followerid where ff.registerid=?");
		   stmt.setInt(1, registerid);
		   rs=stmt.executeQuery();
		  while(rs.next()) {
			  UserInfoModel model=new UserInfoModel();
			  model.setId(rs.getInt(1));
			  model.setName(rs.getString(2));
			  model.setUsername(rs.getString(3));
			  list.add(model);
		  }
		  return list;
		
		
		}catch(Exception ex) {
			return null;
		}
	}
	
	//get following list
	public List <UserInfoModel>isgetFollowingList(int registerid ) {
		List<UserInfoModel> list = new ArrayList<UserInfoModel>();
		try {
			stmt=conn.prepareStatement("select r.registerid, r.name,r.username from userregistrationmaster r inner join followingmaster fwing on r.registerid=fwing.registerid inner join followerfollowingjoin ff on fwing.followingid=ff.followingid where ff.registerid=?");
		   stmt.setInt(1, registerid);
		   rs=stmt.executeQuery();
		  while(rs.next()) {
			  UserInfoModel model=new UserInfoModel();
			  model.setId(rs.getInt(1));
			  model.setName(rs.getString(2));
			  model.setUsername(rs.getString(3));
			  list.add(model);
		  }
		  return list;
		
		
		}catch(Exception ex) {
			return null;
		}
	}
		
	//forget the password
	public boolean forgetPassward(String oldPass,String newPass,int rid) {
		try {
			stmt=conn.prepareStatement("select passward from userregistrationmaster where registerid=?");
			stmt.setInt(1, rid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals(oldPass)) {
					System.out.println("Old Passward match");
					try {
						stmt=conn.prepareStatement("update userregistrationmaster set passward=? where registerid=?");
						stmt.setString(1, newPass);
						stmt.setInt(2, rid);
						int v=stmt.executeUpdate();
						if(v!=0)return true;
						else return false;
						
					}catch(Exception ex) {
						System.out.println("Error is"+ex);
						return false;
						
					}
				}
				else {
					System.out.println("Old passward not Match");
					return false;
				}
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			System.out.println("Error is:"+e);
			return false;
		}
		
		
	}
	
	//Delete Account 
	public boolean isDeleteAccount(int registerid) {
		try {
			stmt=conn.prepareStatement("insert into deleterequest values(?,(curdate()))");
			stmt.setInt(1, registerid);
			return stmt.executeUpdate()>0?true:false;
		}
		catch(Exception ex) {
			return false;
		}
		
	}
	
	//check the delete request to admin panal
	public boolean isCheckDeleteReuest(int registerid) {
		try {
			System.out.println("registerid :"+registerid);
			stmt=conn.prepareStatement("select *from deleterequest where registerid=?");
			stmt.setInt(1, registerid);
			rs=stmt.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception ex) {
			return false;
			
		}
	}
	
	
	//cancel delete account request
	public boolean cancelRequest(int registerid) {
		try {
			stmt=conn.prepareStatement("delete from deleterequest where registerid=?");
			stmt.setInt(1, registerid);
			int v=stmt.executeUpdate();
		    return v>0?true:false;
			
		}catch(Exception ex) {
			return  false;
		}
	}

	//Remove the follower
	@Override
	public boolean isRemoveFollower(int registerid,int userid) {
		try {
			stmt=conn.prepareStatement("select r.registerid ,r.name,r.username,fwer.followerid from userregistrationmaster r inner join followermaster fwer on r.registerid=fwer.registerid inner join followerfollowingjoin ff on fwer.followerid=ff.followerid where ff.registerid=?");
			stmt.setInt(1, userid);
			rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				if(rs.getInt(1)==registerid) {
					stmt=conn.prepareStatement("delete from followermaster where registerid=? && followerid=?");
					stmt.setInt(1, registerid);
					stmt.setInt(2, rs.getInt(4));
					
					
					if(stmt.executeUpdate()==1) {
						stmt=conn.prepareStatement("delete from followerfollowingjoin where registerid=? && followerid=?");
						stmt.setInt(1, userid);
						stmt.setInt(2, rs.getInt(4));
						return stmt.executeUpdate()>0?true:false;
						
					}
					
				}
				
				
			}
		
			return false;
		
		}catch(Exception ex) {
			
			return false;
		}

	}
	
	public boolean isUnfollowUser(int registerid,int userid) {
		try {
			stmt=conn.prepareStatement("select r.registerid, r.name,r.username,fwing.followingid from userregistrationmaster r inner join followingmaster fwing on r.registerid=fwing.registerid inner join followerfollowingjoin ff on fwing.followingid=ff.followingid where ff.registerid=?");
			stmt.setInt(1, userid);
			rs=stmt.executeQuery();
			
			
			while(rs.next()) {
				if(rs.getInt(1)==registerid) {
					stmt=conn.prepareStatement("delete from followingmaster where registerid=? && followingid=?");
					stmt.setInt(1, registerid);
					stmt.setInt(2, rs.getInt(4));
					
					
					if(stmt.executeUpdate()==1) {
						stmt=conn.prepareStatement("delete from followerfollowingjoin where registerid=? && followingid=?");
						stmt.setInt(1, userid);
						stmt.setInt(2, rs.getInt(4));
						return stmt.executeUpdate()>0?true:false;
						
					}
					
				}
				
				
			}
		
			return false;
		
		}catch(Exception ex) {
			
			return false;
		}

		
	}

	@Override
	public List<UserInfoModel> isgetAllUsers() {
		try {
			stmt=conn.prepareStatement("select *From userregistrationmaster");
			rs=stmt.executeQuery();
			List<UserInfoModel> list=new ArrayList <UserInfoModel>();
			while(rs.next()) {
				UserInfoModel model=new UserInfoModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setEmail(rs.getString(3));
				model.setUsername(rs.getString(4));
				model.setPass(rs.getString(5));
				list.add(model);
			}
			
			return list;
			
			
		}catch(Exception ex) {
			return null;
		}
		
	}

	@Override
	public List<UserInfoModel> isgetAllUsersInfoByName(String name) {
		try {
			stmt=conn.prepareStatement("select *From userregistrationmaster where name like '"+name+"%' ");
			
			rs=stmt.executeQuery();
			List<UserInfoModel> list=new ArrayList <UserInfoModel>();
			while(rs.next()) {
				UserInfoModel model=new UserInfoModel();
				model.setId(rs.getInt(1));
				model.setName(rs.getString(2));
				model.setUsername(rs.getString(3));
				model.setEmail(rs.getString(4));
				list.add(model);
			}
			return list;
			
		}catch(Exception ex) {
			return null;
		}
		
	}
			
}
