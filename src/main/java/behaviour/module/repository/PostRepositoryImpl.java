package behaviour.module.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import behaviour.config.DBParent;
import behaviour.module.model.*;

public class PostRepositoryImpl extends DBParent implements PostRepository {

	 // Add the new post
	 public boolean isAddPost(String post, int registerid, String fileName) {
		try {
			stmt = conn.prepareStatement("insert into postmaster values('0',?,(curdate()),(curtime()),?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, post);
			stmt.setString(2, fileName);
			int v = stmt.executeUpdate();
			if (v > 0) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int postid = rs.getInt(1);
					stmt = conn.prepareStatement("insert into postregistrationjoin values(?,?)");
					stmt.setInt(1, postid);
					stmt.setInt(2, registerid);
					v = stmt.executeUpdate();
					return (v > 0) ? true : false;

				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			System.out.println("Error is " + ex);
			return false;
		}
	}

	// view Trending post
	public List viewTrendingpost() {
		List list = new ArrayList();
		try {
			stmt = conn.prepareStatement("select postname from postmaster order by date desc");
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

	// view personal post
	public List viewPersonalpost(int rid) {
		List list = new ArrayList();
		try {
			stmt = conn.prepareStatement(
					"select p.postname,p.date,p.time  from postmaster p inner join postregistrationjoin prj on p.postid=prj.postid where prj.registerid=?");
			stmt.setInt(1, rid);
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

	// get perticular post id
	public int getPostId(String post) {
		try {
			stmt = conn.prepareStatement("select postid from postmaster where postname=?");
			stmt.setString(1, post);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return 0;
			}

		} catch (Exception ex) {
			return 0;
		}
	}

	// like the post
	public boolean islikePost(int userid, int postid) {
		try {
			// Check if the user has already liked the post
			stmt = conn.prepareStatement(
					"SELECT * FROM likepostjoin WHERE likeid IN (SELECT likeid FROM likemaster WHERE registerid=?) AND postid=?");
			stmt.setInt(1, userid);
			stmt.setInt(2, postid);
			rs = stmt.executeQuery();

			if (rs.next()) {

				return false;

			} else {
				// Insert a new like into likemaster
				stmt = conn.prepareStatement("INSERT INTO likemaster values('0',?)",
						PreparedStatement.RETURN_GENERATED_KEYS);
				stmt.setInt(1, userid);
				int v = stmt.executeUpdate();

				if (v > 0) {
					rs = stmt.getGeneratedKeys();
					if (rs.next()) {
						int likeid = rs.getInt(1);

						// Insert into likepostjoin
						stmt = conn.prepareStatement("INSERT INTO likepostjoin  VALUES (?, ?)");
						stmt.setInt(1, likeid);
						stmt.setInt(2, postid);
						v = stmt.executeUpdate();

						return v > 0 ? true : false;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}

		} catch (Exception ex) {

			return false;
		}

	}

	// comment the post
	public boolean isCommenPost(int userid, int postid, String comment) {

		try {
			stmt = conn.prepareStatement("INSERT INTO commentmaster values('0',?,(curdate()),?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, comment);
			stmt.setInt(2, userid);
			int v = stmt.executeUpdate();

			if (v > 0) {
				rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					int commentid = rs.getInt(1);
					System.out.println("postid:" + postid);
					System.out.println("comment id:" + commentid);

					// Insert into postcommentjoin
					stmt = conn.prepareStatement("insert into postcommentjoin values(?,?)");
					stmt.setInt(1, postid);
					stmt.setInt(2, commentid);
					v = stmt.executeUpdate();

					return v > 0 ? true : false;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception ex) {
			return false;
		}

	}

	// count like of personal post (count like of post according to user id)
	public List countLikeOfPersonlPost(int userid) {
		try {
			stmt = conn.prepareStatement(
					"SELECT p.postid, p.postname, GROUP_CONCAT(cm.comment SEPARATOR ', ') AS comments,count(lpj.likeid)as likeCount,count(pcj.commentid)as commentCount FROM postmaster p INNER JOIN postcommentjoin pcj ON p.postid = pcj.postid INNER JOIN commentmaster cm ON pcj.commentid = cm.commentid inner join likepostjoin lpj on p.postid=lpj.postid inner join likemaster lm on lpj.likeid=lm.likeid WHERE cm.registerid =? GROUP BY p.postid");
			stmt.setInt(1, userid);
			rs = stmt.executeQuery();
			List<PostLikeCount> likecountlist = new ArrayList();

			while (rs.next()) {
				PostLikeCount plc = new PostLikeCount();
				plc.setPostid(rs.getInt(1));
				plc.setPost(rs.getString(2));
				plc.setComment(rs.getString(3));
				plc.setCount(rs.getInt(4));
				plc.setCommentCount(rs.getInt(5));
				likecountlist.add(plc);
			}
			return likecountlist.size() > 0 ? likecountlist : null;
		} catch (Exception ex) {
			return null;
		}

	}

	// view All posts or like,comment date wise decreasing order particular user/
	public List<PostLikeCount> ViewAllPosts(int registerIDSearchUser) {
		List<PostLikeCount> list = new LinkedList<PostLikeCount>(); // store particular user post id ,post,like,comment
																	// count

		ArrayList<Integer> alPost = new ArrayList<Integer>(); // store post id particular user
		PostLikeCount pmodel;
		try {
			// we fetch post id and store in ArrayList
			stmt = conn.prepareStatement(
					"select pm.postid from postmaster pm inner join postregistrationjoin prj on pm.postid=prj.postid inner join userregistrationmaster rm on rm.registerid=prj.registerid where rm.registerid=? order by pm.date desc");
			stmt.setInt(1, registerIDSearchUser);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int postID = rs.getInt(1);
				alPost.add(postID);
			}

			// we fetch post id ,post , count like ,comment count for particular post
			int postcount = 0;
			if (alPost.size() > 0) { // we check user posts not found
				for (Integer lc : alPost) {

					pmodel = new PostLikeCount();

					pmodel.setPostid(lc); // set post id

					stmt = conn.prepareStatement("select postname,filename from postmaster where postid=?");
					stmt.setInt(1, lc);
					rs = stmt.executeQuery();
					if (rs.next()) {
						pmodel.setPost(rs.getString(1)); // set post
						pmodel.setFilename(rs.getString(2)); //set file 
					}

					// we fetch like count of post
					stmt = conn.prepareStatement(
							"select count(lm.likeid) from likemaster lm inner join likepostjoin lpj on lpj.likeid=lm.likeid inner join postmaster pm on pm.postid=lpj.postid where pm.postid=?");
					stmt.setInt(1, lc);
					rs = stmt.executeQuery();
					if (rs.next()) {
						pmodel.setCount(rs.getInt(1)); // set count like post
					}

					// we fetch comment count of post
					stmt = conn.prepareStatement(
							"select count(cm.commentid) from commentmaster cm inner join postcommentjoin pcj on pcj.commentid=cm.commentid inner join postmaster pm on pm.postid=pcj.postid where pm.postid=?");
					stmt.setInt(1, lc);
					rs = stmt.executeQuery();
					if (rs.next()) {
						pmodel.setCommentCount(rs.getInt(1)); // set comment count of post
					}
					pmodel.setPostCount(++postcount);
					list.add(pmodel);
				}
			}

			return (list.size() > 0) ? list : null;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean isdeletePost(int postid) {
		try {
			stmt = conn.prepareStatement("delete from postregistrationjoin where postid=?");
			stmt.setInt(1, postid);
			if (stmt.executeUpdate() == 1) {
				stmt = conn.prepareStatement(" delete from postmaster where postid=?");
				stmt.setInt(1, postid);
				stmt.executeUpdate();
				return true;
			} else {
				return false;
			}

		} catch (Exception ex) {
			return false;
		}

	}

	@Override
	public List<List<Object>> getFriendsFollowerPosts(int registerid) {

	    List<List<Object>> list = new ArrayList<>();
	    
	    try {
	        stmt = conn.prepareStatement(
	                " SELECT r.username, r.name, p.postid, p.postname, p.date, p.time,p.filename FROM postmaster p INNER JOIN postregistrationjoin prj ON p.postid = prj.postid INNER JOIN userregistrationmaster r ON r.registerid = prj.registerid WHERE prj.registerid in (select r.registerid from userregistrationmaster r inner join followingmaster fwer on r.registerid = fwer.registerid inner join followerfollowingjoin ff on fwer.followingid = ff.followingid where ff.registerid =?)");
	        stmt.setInt(1, registerid);
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            UserInfoModel umodel = new UserInfoModel();
	            PostLikeCount pmodel = new PostLikeCount();
	            umodel.setUsername(rs.getString(1));
	            umodel.setName(rs.getString(2));
	            pmodel.setPostid(rs.getInt(3));
	            pmodel.setPost(rs.getString(4));
	            pmodel.setFilename(rs.getString(7));

	            // Fetch like count of post
	            PreparedStatement likeStmt = conn.prepareStatement(
	                    "select count(lm.likeid) from likemaster lm " +
	                    "inner join likepostjoin lpj on lpj.likeid = lm.likeid " +
	                    "inner join postmaster pm on pm.postid = lpj.postid " +
	                    "where pm.postid = ?");
	            likeStmt.setInt(1, rs.getInt(3));
	            ResultSet likeRs = likeStmt.executeQuery();
	            if (likeRs.next()) {
	                pmodel.setCount(likeRs.getInt(1));
	            }
	            likeRs.close();
	            likeStmt.close();

	            // Fetch comment count of post
	            PreparedStatement commentStmt = conn.prepareStatement(
	                    "select count(cm.commentid) from commentmaster cm " +
	                    "inner join postcommentjoin pcj on pcj.commentid = cm.commentid " +
	                    "inner join postmaster pm on pm.postid = pcj.postid " +
	                    "where pm.postid = ?");
	            commentStmt.setInt(1, rs.getInt(3));
	            ResultSet commentRs = commentStmt.executeQuery();
	            if (commentRs.next()) {
	                pmodel.setCommentCount(commentRs.getInt(1));
	            }
	            commentRs.close();
	            commentStmt.close();

	            List<Object> upmodellist = new ArrayList<>();
	            upmodellist.add(pmodel);
	            upmodellist.add(umodel);
	            list.add(upmodellist);
	        }
	        rs.close();
	        stmt.close();
	    } catch (Exception ex) {
	        ex.printStackTrace(); // Consider logging the exception properly
	        return null;
	    }

	    return list;
	}

	public List<List<Object>> getForYou() {

	    List<List<Object>> list = new ArrayList<>();
	    
	    try {
	        stmt = conn.prepareStatement(
	                "select r.username, r.name, p.postid, p.postname, p.date, p.time,p.filename from postmaster p inner join postregistrationjoin prj on p.postid = prj.postid inner join userregistrationmaster r on r.registerid = prj.registerid");
	        rs = stmt.executeQuery();

	        while (rs.next()) {
	            UserInfoModel umodel = new UserInfoModel();
	            PostLikeCount pmodel = new PostLikeCount();
	            umodel.setUsername(rs.getString(1));
	            umodel.setName(rs.getString(2));
	            pmodel.setPostid(rs.getInt(3));
	            pmodel.setPost(rs.getString(4));
	            pmodel.setFilename(rs.getString(7));

	            // Fetch like count of post
	            PreparedStatement likeStmt = conn.prepareStatement(
	                    "select count(lm.likeid) from likemaster lm " +
	                    "inner join likepostjoin lpj on lpj.likeid = lm.likeid " +
	                    "inner join postmaster pm on pm.postid = lpj.postid " +
	                    "where pm.postid = ?");
	            likeStmt.setInt(1, rs.getInt(3));
	            ResultSet likeRs = likeStmt.executeQuery();
	            if (likeRs.next()) {
	                pmodel.setCount(likeRs.getInt(1));
	            }
	            likeRs.close();
	            likeStmt.close();

	            // Fetch comment count of post
	            PreparedStatement commentStmt = conn.prepareStatement(
	                    "select count(cm.commentid) from commentmaster cm " +
	                    "inner join postcommentjoin pcj on pcj.commentid = cm.commentid " +
	                    "inner join postmaster pm on pm.postid = pcj.postid " +
	                    "where pm.postid = ?");
	            commentStmt.setInt(1, rs.getInt(3));
	            ResultSet commentRs = commentStmt.executeQuery();
	            if (commentRs.next()) {
	                pmodel.setCommentCount(commentRs.getInt(1));
	            }
	            commentRs.close();
	            commentStmt.close();

	            List<Object> upmodellist = new ArrayList<>();
	            upmodellist.add(pmodel);
	            upmodellist.add(umodel);
	            list.add(upmodellist);
	        }
	        rs.close();
	        stmt.close();
	    } catch (Exception ex) {
	        return null;
	    }

	    return list;
	}

	

}
