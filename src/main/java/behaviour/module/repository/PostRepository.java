package behaviour.module.repository;

import java.util.List;

import behaviour.module.model.PostLikeCount;

public interface PostRepository {

	 boolean isAddPost(String post, int registerid, String fileName);
public List viewTrendingpost() ;

public List viewPersonalpost(int rid) ;

public int getPostId(String post);
public boolean islikePost(int userid,int postid);
public boolean isCommenPost(int userid ,int postid,String comment) ;

public List countLikeOfPersonlPost(int userid);
public List<PostLikeCount> ViewAllPosts(int registerIDSearchUser);
public boolean isdeletePost(int postid) ;
public List<List<Object>> getFriendsFollowerPosts(int registerid);
public List<List<Object>> getForYou() ;
}


