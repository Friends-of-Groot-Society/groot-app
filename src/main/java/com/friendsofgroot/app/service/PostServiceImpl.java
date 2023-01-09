package com.friendsofgroot.app.service;

import com.friendsofgroot.app.dto.PostEntityDto;
import com.friendsofgroot.app.dto.PostEntityResponse;
import com.friendsofgroot.app.exception.ResourceNotFoundException;
import com.friendsofgroot.app.mapper.PostEntityMapper;
import com.friendsofgroot.app.models.PostEntity;
import  com.friendsofgroot.app.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostRepository pr;
//	public PostServiceImpl(PostRepository postRepository) {
//		this.pr = postRepository;
//	}
	@Autowired
	private PostEntityMapper postEntityMapper;

	@Override
	public PostEntityDto createPost(PostEntityDto postEntityDto) {
		PostEntity postEntity = postEntityMapper.PostEntityDTOToPostEntity(postEntityDto);
		PostEntity newPostEntity = pr.save(postEntity);

		PostEntityDto postResponse = postEntityMapper.PostEntityToPostEntityDTO(newPostEntity);
		return postResponse;
	}
	@Override
	public PostEntityResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<PostEntity> posts = pr.findAll(pageable);

		// get content for page object
		List<PostEntity> listOfPosts = posts.getContent();

		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.PostEntityToPostEntityDTO(post)).collect(Collectors.toList());

		PostEntityResponse postResponse = new PostEntityResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;
	}
	@Override
	public PostEntityResponse getAllPostsByUsername(int pageNo, int pageSize, String sortBy, String sortDir, String username) {

		Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
				: Sort.by(sortBy).descending();

		// create Pageable instance
		Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

		Page<PostEntity> posts = pr.findAllByUsername(pageable, username);

		// get content for page object
		List<PostEntity> listOfPosts = posts.getContent();

		List<PostEntityDto> content= listOfPosts.stream().map(post -> postEntityMapper.PostEntityToPostEntityDTO(post)).collect(Collectors.toList());

		PostEntityResponse postResponse = new PostEntityResponse();
		postResponse.setContent(content);
		postResponse.setPageNo(posts.getNumber());
		postResponse.setPageSize(posts.getSize());
		postResponse.setTotalElements(posts.getTotalElements());
		postResponse.setTotalPages(posts.getTotalPages());
		postResponse.setLast(posts.isLast());

		return postResponse;
	}
//	@Override
//	public List<PostEntityDto> getAllPostsByUsername(String username) {
//		try {
//			return (List<PostEntityDto>) pr.findAllByUsername(username) ;
//		} catch (Exception e) {
//			return null;
//		}
//	}
	@Override
	public PostEntityDto getPostById(long id) {
		PostEntity post = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("PostEntity", "id", Long.toString(id)));
		return postEntityMapper.PostEntityToPostEntityDTO(post);
 	}

	@Override
	public PostEntityDto getPostByDid(String did) {
		PostEntity post = pr.findByDid(did).orElseThrow(() -> new ResourceNotFoundException("PostEntity", "did", did));
		return postEntityMapper.PostEntityToPostEntityDTO(post);
	}

//	@Override
//	public PostEntityDto updatesPost(PostEntityDto change) {
//		return pr.save(change);
//	}
	@Override
	public PostEntityDto updatePost(PostEntityDto postDto, long id) {
		// get post by id from the database
		PostEntity postOld = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", Long.toString(id)));

		postOld.setDid(postDto.getDid());
		postOld.setPost(postDto.getPost());
		postOld.setTitle(postDto.getTitle());
		postOld.setAuthor(postDto.getAuthor());
		postOld.setCat3(postDto.getCat3());
		postOld.setMonthOrder(postDto.getMonthOrder());
		postOld.setBlogcite(postDto.getBlogcite());

		PostEntity updatedPost = pr.save(postOld);
		return postEntityMapper.PostEntityToPostEntityDTO(updatedPost);
	}
	@Override
	public boolean deletePostById(long id) {
		// get post by id from the database
		try {
			PostEntity post = pr.findById(id).orElseThrow(() -> new ResourceNotFoundException("Post", "id", Long.toString(id)));
			pr.delete(post);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

 
}
