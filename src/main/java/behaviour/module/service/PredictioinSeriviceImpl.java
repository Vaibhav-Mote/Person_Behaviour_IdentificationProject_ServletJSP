package behaviour.module.service;

import java.util.List;

import behaviour.module.model.PredictionModel;
import behaviour.module.repository.*;

public class PredictioinSeriviceImpl implements PredictionService {
	PredictionRepository predRepo=new PredictionRepositoryImpl();
	
	public int getPostId(int postid,int predictUserID) {
		return predRepo.getPostId(postid, predictUserID);
	}
	
	public String predictPersonBehavior(String post) {
		int result= predRepo.predictPersonBehavior(post);
		if(result==1) {
			return "Openess to Experience";
		}else if(result==2) {
			return "Conscientiousness";
		}
		else if(result==3) {
			return "Extraversion";
		}
		else if(result==4) {
			return "Agreeableness";
		}
		else {
			return "Neuroticism";
		}
			
		}
	public List<PredictionModel> predictOverAllPersonBehavior(String[] unlabelledInformation){
		return predRepo.predictOverAllPersonBehavior(unlabelledInformation);
	}
	public String[] getAllPostsCommentsLikes(int predictUserID) {
		return predRepo.getAllPostsCommentsLikes(predictUserID);
	}
}
