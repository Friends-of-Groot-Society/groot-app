package com.friendsofgroot.app.controllers;

import com.friendsofgroot.app.dto.PostEntityDto;
import com.friendsofgroot.app.dto.PostEntityResponse;
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

@RequestMapping(path = "/api/posts")
@CrossOrigin(origins = "*")
@RestController
public class PostEntityController {

    @Autowired
    private PostService postService;

	@Autowired
	private PostEntityMapper postEntityMapper;

    @PostMapping
    public ResponseEntity<PostEntityDto> createPost(@RequestBody PostEntityDto postEntityDto){
        return new ResponseEntity<>(postService.createPost(postEntityDto), HttpStatus.CREATED);
    }

    @GetMapping
    public PostEntityResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }
//    @GetMapping(path = "/posts")
//    public ResponseEntity<List<PostEntity>> getAllPosts() {
//        return new ResponseEntity<>(
//                postEntityMapper.PostEntitysToPostEntityDTOs(
//                        postService.getAllPosts()
//                ), HttpStatus.OK);
//    }
    @GetMapping("/username/{username}")
    public PostEntityResponse getAllPostsByUsername(
            @RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
            @PathVariable String username
    ){
        return postService.getAllPostsByUsername(pageNo, pageSize, sortBy, sortDir, username);
    }
//    @GetMapping(path = "/posts/{username}")
//    public ResponseEntity<List<PostEntity>> getAllPostsByUsername(@PathVariable String username) {
//        return new ResponseEntity<>(
//				postEntityMapper.PostEntitysToPostEntityDTOs(
//						postService.getAllPostsByUsername(username)
//                ), HttpStatus.OK);
//    }
    @GetMapping("/{id}")
    public ResponseEntity<PostEntityDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @GetMapping("/date/{did}")
    public ResponseEntity<PostEntityDto> getPostByDid(@PathVariable(name = "did") String did){
        return ResponseEntity.ok(postService.getPostByDid(did));
    }
//    @GetMapping(path = "/posts/{username}/{id}")
//    public ResponseEntity<PostEntityDto> getPostByUsernameAndId(@PathVariable String username, @PathVariable long id) {
////        return postRepository.findById(id).get();
//        		return new ResponseEntity<>(
//                                        postEntityMapper.PostEntityToPostEntityDTO(
//                                                postService.getPostByUsernameAndId(username, id)),
//                                        HttpStatus.OK);
//    }
    @PutMapping("/{id}")
    public ResponseEntity<PostEntityDto> updatePost(@RequestBody PostEntityDto postEntityDto, @PathVariable(name = "id") long id){
        PostEntityDto postResponse = postService.updatePost(postEntityDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }
//    @PutMapping(path = "/posts/{username}/{id}")
//    public ResponseEntity<PostEntity> updatePost(
//            @PathVariable String username,
//            @PathVariable long id, @RequestBody PostEntity postEntity) {
//        postEntity.setUsername(username);
//        PostEntity postUpdated = postService.createPost(postEntity);
//        		 return new ResponseEntity<PostEntity>(postEntity, HttpStatus.OK);
//    }
@DeleteMapping("/{id}")
public ResponseEntity<Boolean> deletePostById(@PathVariable(name = "id") long id){
    try {
        postService.deletePostById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
//    @DeleteMapping(path = "/posts/{username}/{id}")
//    public ResponseEntity<Boolean> deletePost(
//            @PathVariable String username, @PathVariable long id) {
//          PostEntity post = postService.getPostByUsernameAndId(username, id);
//          postService.deletePost(post);
//        		if(post!=null) {
//                    return new ResponseEntity<>(true, HttpStatus.OK);
//        		}
////        		return ResponseEntity.notFound().build();
//                return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
//    }

}
