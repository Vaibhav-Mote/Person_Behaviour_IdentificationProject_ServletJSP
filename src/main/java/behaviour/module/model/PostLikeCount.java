package behaviour.module.model;

import java.util.List;

public class PostLikeCount {
private int count;
private String post;
private int postid;
private int commentCount;
private int postCount;
private String filename;
public int getPostCount() {
	return postCount;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public void setPostCount(int postCount) {
	this.postCount = postCount;
}
public int getCommentCount() {
	return commentCount;
}
public void setCommentCount(int commentCount) {
	this.commentCount = commentCount;
}
public int getPostid() {
	return postid;
}
public void setPostid(int postid) {
	this.postid = postid;
}
private String comment;
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
}
