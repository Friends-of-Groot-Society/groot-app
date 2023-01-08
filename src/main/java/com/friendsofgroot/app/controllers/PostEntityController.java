package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.dto.PostEntityDto;
import com.friendsofgroot.app.mapper.PostEntityMapper;
import com.friendsofgroot.app.models.PostEntity;
import com.friendsofgroot.app.repositories.PostRepository;
import com.friendsofgroot.app.service.PostService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
@RestController
public class PostEntityController {

    @Autowired
    private PostService postService;

	@Autowired
	private PostEntityMapper postEntityMapper;


    @PostMapping(path = "/posts/{username}")
    public ResponseEntity<PostEntity> createPost(
            @PathVariable String username,
            @RequestBody PostEntity post
    ) {
        post.setUsername(username);
        PostEntity postCreated = postService.createPost(post);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(postCreated.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/posts")
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        return new ResponseEntity<>(
                postEntityMapper.PostEntitysToPostEntityDTOs(
                        postService.getAllPosts()
                ), HttpStatus.OK);
    }


    @GetMapping(path = "/posts/{username}")
    public ResponseEntity<List<PostEntity>> getAllPostsByUsername(@PathVariable String username) {
        return new ResponseEntity<>(
				postEntityMapper.PostEntitysToPostEntityDTOs(
						postService.getAllPostsByUsername(username)
                ), HttpStatus.OK);
    }



    @GetMapping(path = "/posts/{username}/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PostEntityDto> getPostByUsernameAndId(@PathVariable String username, @PathVariable long id) {
//        return postRepository.findById(id).get();
        		return new ResponseEntity<>(
                                        postEntityMapper.PostEntityToPostEntityDTO(
                                                postService.getPostByUsernameAndId(username, id)),
                                        HttpStatus.OK);
    }


    @PutMapping(path = "/posts/{username}/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<PostEntity> updatePost(
            @PathVariable String username,
            @PathVariable long id, @RequestBody PostEntity postEntity) {
        postEntity.setUsername(username);
        PostEntity postUpdated = postService.createPost(postEntity);
        		 return new ResponseEntity<PostEntity>(postEntity, HttpStatus.OK);
    }

    @DeleteMapping(path = "/posts/{username}/{id}")
    @CrossOrigin(origins = "*")
    public ResponseEntity<Boolean> deletePost(
            @PathVariable String username, @PathVariable long id) {
          PostEntity post = postService.getPostByUsernameAndId(username, id);
          postService.deletePost(post);
        		if(post!=null) {
                    return new ResponseEntity<>(true, HttpStatus.OK);
        		}
//        		return ResponseEntity.notFound().build();
                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

}
