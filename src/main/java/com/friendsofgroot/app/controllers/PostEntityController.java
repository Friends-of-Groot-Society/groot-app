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
import com.friendsofgroot.app.util.constants.*;

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

    @PostMapping("")
    public ResponseEntity<PostEntityDto> createPost(@RequestBody PostEntityDto postEntityDto){
        return new ResponseEntity<>(postService.createPost(postEntityDto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public PostEntityResponse getAllPosts(
            @RequestParam(value = "pageNo", defaultValue = Datum.DEFAULT_PAGE_NUMBER,  required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Datum.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Datum.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Datum.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ){
        return postService.getAllPosts(pageNo, pageSize, sortBy, sortDir);
    }

    @GetMapping("/username/{username}")
    public PostEntityResponse getAllPostsByUsername(
            @RequestParam(value = "pageNo", defaultValue = Datum.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = Datum.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue =  Datum.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = Datum.DEFAULT_SORT_DIRECTION, required = false) String sortDir,
            @PathVariable String username
    ){
        return postService.getAllPostsByUsername(pageNo, pageSize, sortBy, sortDir, username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostEntityDto> getPostById(@PathVariable(name = "id") long id){
        return ResponseEntity.ok(postService.getPostById(id));
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostEntityDto>> getPostsByCategoryId(@PathVariable( "categoryId") long categoryId){
        List<PostEntityDto> postEntityDtoList = (List<PostEntityDto>) postService.getPostsByCategoryId(categoryId);
        return ResponseEntity.ok(postEntityDtoList);
    }


    @GetMapping("/date/{did}")
    public ResponseEntity<PostEntityDto> getPostByDid(@PathVariable(name = "did") String did){
        return ResponseEntity.ok(postService.getPostByDid(did));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostEntityDto> updatePost(@RequestBody PostEntityDto postEntityDto, @PathVariable(name = "id") long id){
        PostEntityDto postResponse = postService.updatePost(postEntityDto, id);
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

@DeleteMapping("/{id}")
public ResponseEntity<Boolean> deletePostById(@PathVariable(name = "id") long id){
    try {
        postService.deletePostById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}

}
