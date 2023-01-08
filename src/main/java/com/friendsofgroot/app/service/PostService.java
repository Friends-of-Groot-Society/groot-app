package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.PostEntity;

import java.util.List;

public interface PostService {
	public PostEntity createPost(PostEntity post);
	public PostEntity getPostById(Long id); 
	public PostEntity getPostByDid(String did);

	public PostEntity getPostByUsernameAndId(String username, long id);
	public List<PostEntity> getAllPostsByUsername(String username);

	public List<PostEntity> getAllPosts();
	public List<PostEntity> findAll();
	public PostEntity updatesPost(PostEntity change);
	public boolean deletePost(PostEntity post);

}
