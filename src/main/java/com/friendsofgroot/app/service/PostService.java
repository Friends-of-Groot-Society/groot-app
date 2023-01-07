package net.ourdailytech.rest.webservice.services;

import java.util.List;
 
import net.ourdailytech.rest.webservice.entities.PostEntity;

public interface PostService {
	public PostEntity createPost(PostEntity post);
	public PostEntity getPostById(Long id); 
	public PostEntity getPostByDid(String did);
 
	
	public List<PostEntity> getAllPosts();
	public List<PostEntity> findAll();
	public PostEntity updatesPost(PostEntity change);
	public boolean deletePost(PostEntity post);
}
