package behaviour.module.service;

import java.util.List;

import behaviour.module.model.PostLikeCount;
import behaviour.module.model.PredictionModel;

public interface PredictionService {

	public int getPostId(int postid,int predictUserID) ;
	public String predictPersonBehavior(String post);
	public List<PredictionModel> predictOverAllPersonBehavior(String[] unlabelledInformation);
	public String[] getAllPostsCommentsLikes(int predictUserID);
}
