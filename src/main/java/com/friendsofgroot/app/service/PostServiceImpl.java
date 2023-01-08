package com.friendsofgroot.app.service;

import com.friendsofgroot.app.models.PostEntity;
import  com.friendsofgroot.app.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository pr;
	
	@Override
	public PostEntity createPost(PostEntity post) {
		return pr.save(post);
	}

	@Override
	public PostEntity getPostByDid(String did) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param username
	 * @param id
	 * @return
	 */
	@Override
	public PostEntity getPostByUsernameAndId(String username, long id) {
		return null;
	}

	@Override
	public PostEntity getPostById(Long id) {
		return pr.findById(id).get();
		}

	
	
	@Override
	public List<PostEntity> getAllPostsByUsername(String username) {
	try {
		return (List<PostEntity>) pr.findAllByUsername(username) ;
	} catch (Exception e) {
	return null;
	}
	}

	@Override
	public List<PostEntity> getAllPosts() {
		return (List<PostEntity>) pr.findAll();
	}
	
	@Override
	public List<PostEntity> findAll() {
		// TODO Auto-generated method stub
		return (List<PostEntity>) pr.findAll();
	}
	
	@Override
	public PostEntity updatesPost(PostEntity change) {
		return pr.save(change);
	}

	@Override
	public boolean deletePost(PostEntity post) {
		try {
			pr.delete(post);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true; 
	}
 
}
