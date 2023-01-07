package net.ourdailytech.rest.webservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ourdailytech.rest.webservice.entities.PostEntity;
import net.ourdailytech.rest.webservice.repositories.PostRepository;

import net.ourdailytech.rest.webservice.services.PostService; 

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
	@Override
	public PostEntity getPostById(Long id) {
		return pr.findById(id).get();
		}

	
	
//	@Override
//	public PostEntity getPostByUsername(String username) {
//	try {
//		return pr.findByUsername(username).get(); 
//	} catch (Exception e) {
//	return null;
//	}
//	}

//	@Override
//	public Object getPostByUsernameAndPassword(String email, String password) {
//		return er.findByUsernameAndPassword(email).get(); 
//	}
	
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
