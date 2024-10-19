package behaviour.module.repository;

import java.util.List;



import behaviour.module.model.PostLikeCount;
import behaviour.module.model.PredictionModel;

public interface PredictionRepository {
	public int getPostId(int postid,int predictUserID) ;
	public int predictPersonBehavior(String post);
	public List<PredictionModel> predictOverAllPersonBehavior(String[] unlabelledInformation);
	public String[] getAllPostsCommentsLikes(int predictUserID);

}
