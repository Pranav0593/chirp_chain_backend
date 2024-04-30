package com.example.oop.Controllers;

import com.example.oop.Requests.CreatePostRequest;
import com.example.oop.Requests.DeletePostRequest;
import com.example.oop.Requests.UpdatePostRequest;
import com.example.oop.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {


    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Object> createPost(@RequestBody CreatePostRequest requestToCreatePost)
    {
        return postService.createPost(requestToCreatePost);
    }

    @GetMapping
    public ResponseEntity<Object> getPostDetails(@RequestParam Integer postID)
    {
        return postService.getPostDetails(postID);
    }

    @PatchMapping
    public ResponseEntity<Object> updatePost(@RequestBody UpdatePostRequest requestToUpdatePost)
    {
        return postService.updatePost(requestToUpdatePost);
    }

    @DeleteMapping
    public ResponseEntity<Object> deletePost(@RequestBody DeletePostRequest deletePostRequest)
    {
        return postService.deletePost(deletePostRequest);
    }

}
