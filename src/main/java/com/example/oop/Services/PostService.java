package com.example.oop.Services;

import com.example.oop.Entities.AppUser;
import com.example.oop.ErrorHandler;
import com.example.oop.Entities.Post;
import com.example.oop.Repository.PostRepository;
import com.example.oop.Repository.UserRepository;
import com.example.oop.Requests.CreatePostRequest;
import com.example.oop.Requests.DeletePostRequest;
import com.example.oop.Requests.UpdatePostRequest;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service

public class PostService
{
    private final PostRepository postRepo;
    private final UserRepository userRepo;

    @Autowired
    public PostService(PostRepository postRepo, UserRepository userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }



    public ResponseEntity<Object> createPost( CreatePostRequest requestToCreatePost)
    {
         Integer userId = requestToCreatePost.getUserID();
        Optional<AppUser> appUser = userRepo.findById( userId);
        if (appUser.isEmpty())
        {
           ErrorHandler errorHandler = new ErrorHandler("User does not exist");
            return errorHandler.getErrorResponse();
        }
        else
        {
            Post post = new Post(requestToCreatePost.getPostBody());
            post.setUser(appUser.get());
            postRepo.save(post);
            userRepo.save(appUser.get());
            return new ResponseEntity<>("Post created successfully", HttpStatus.OK);
        }

    }


        public ResponseEntity<Object> getPostDetails( Integer postID)
    {
        Optional<Post> post = postRepo.findById(postID);

        if (post.isPresent())
        {
            Post myPost = post.get();
            return new ResponseEntity<>(myPost,HttpStatus.OK);
        }

        else
        {
            ErrorHandler errorHandler = new ErrorHandler("Post does not exist");
            return errorHandler.getErrorResponse();
        }

    }


    public ResponseEntity<Object> updatePost( UpdatePostRequest request)
    {

        Optional<Post> optionalPost= postRepo.findById(request.getPostID());

        if (optionalPost.isEmpty())
        {
           ErrorHandler errorHandler = new ErrorHandler("Post does not exist");
            return errorHandler.getErrorResponse();
        }
        else
        {
            Post post = optionalPost.get();
            post.setPostBody(request.getPostBody());
            postRepo.save(post);
            return new ResponseEntity<>("Post edited successfully", HttpStatus.OK);
        }
    }


    public ResponseEntity<Object> deletePost( DeletePostRequest deletePostRequest)
    {

           Optional<Post> myPost= postRepo.findById(deletePostRequest.getPostID());
           if(myPost.isEmpty())
           {
               ErrorHandler errorHandler = new ErrorHandler("Post does not exist");
                return errorHandler.getErrorResponse();
           }
            postRepo.deleteById(deletePostRequest.getPostID());
            return new ResponseEntity<>("Post deleted", HttpStatus.OK);
    }


}