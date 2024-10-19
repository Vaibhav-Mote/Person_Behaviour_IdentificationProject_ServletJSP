package behaviour.module.service;

import java.util.List;

import behaviour.module.model.PostLikeCount;
import  behaviour.module.repository.*;

public class PostServiceImpl implements PostService {
	PostRepository postRepo=new PostRepositoryImpl();
	
	
	public List viewTrendingpost() {
		return postRepo.viewTrendingpost();
	}

	public List viewPersonalpost(int rid) {
		return postRepo.viewPersonalpost(rid);
	}

	public int getPostId(String post) {
		return postRepo.getPostId(post);
	}
	public boolean islikePost(int userid,int postid) {
		return postRepo.islikePost(userid,postid);
	}
	public boolean isCommenPost(int userid ,int postid,String comment) {
		return postRepo.isCommenPost(userid, postid, comment);
	}

	public List countLikeOfPersonlPost(int userid) {
		return postRepo.countLikeOfPersonlPost(userid);
	}
	public List<PostLikeCount> ViewAllPosts(int registerIDSearchUser){
		return postRepo.ViewAllPosts(registerIDSearchUser);
	}

	@Override
	public boolean isdeletePost(int postid) {
		return postRepo.isdeletePost(postid);
	}

	@Override
	public List<List<Object>> getFriendsFollowerPosts(int registerid) {
		return postRepo.getFriendsFollowerPosts(registerid);
	}

	@Override
	public List<List<Object>> getForYou() {
		return postRepo.getForYou();
	}

	@Override
	public boolean isAddPost(String post, int registerid, String fileName) {
		// TODO Auto-generated method stub
		return postRepo.isAddPost(post, registerid, fileName);
	}

}
