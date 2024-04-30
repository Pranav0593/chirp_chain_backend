package com.example.oop.Services;

import com.example.oop.*;
import com.example.oop.Entities.AppUser;
import com.example.oop.Entities.Comment;
import com.example.oop.Entities.CommentCreator;
import com.example.oop.Entities.Post;
import com.example.oop.Repository.CommentRepository;
import com.example.oop.Repository.PostRepository;
import com.example.oop.Repository.UserRepository;
import com.example.oop.Requests.CreateCommentRequest;
import com.example.oop.Requests.DeleteCommentRequest;
import com.example.oop.Requests.UpdateCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Optional;



@Service
public class CommentService {

    private final PostRepository postRepo;
    private final UserRepository userRepo;
    private final CommentRepository commentRepo;

    @Autowired
    public CommentService(UserRepository userRepo, PostRepository postRepo, CommentRepository commentRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
    }


    public ResponseEntity<Object> createComment( CreateCommentRequest requestToCreateComment)
    {
        Integer userId = requestToCreateComment.getUserID();
        Integer postId = requestToCreateComment.getPostID();
        Optional<AppUser> appUser = userRepo.findById(userId);
        Optional<Post> post = postRepo.findById(postId);

        if (appUser.isEmpty())
        {
            ErrorHandler errorHandler = new ErrorHandler("User does not exist");
            return errorHandler.getErrorResponse();
        }
        else if (post.isEmpty())
        {
            ErrorHandler errorHandler = new ErrorHandler("Post does not exist");
            return errorHandler.getErrorResponse();
        }
        else
        {
            CommentCreator commentCreator = new CommentCreator( appUser.get().getId(), appUser.get().getName());
            Comment comment = new Comment(requestToCreateComment.getCommentBody(), commentCreator, post.get());
            commentRepo.save(comment);
            return new ResponseEntity<>("Comment created successfully", HttpStatus.OK);
        }

    }

    public ResponseEntity<Object> getCommentDetails(Integer commentID)
    {
        Optional<Comment> comment = commentRepo.findById(commentID);

        if (comment.isPresent())
        {
            Comment myComment = comment.get();
            return new ResponseEntity<>(myComment,HttpStatus.OK);
        }

       else
            {
                ErrorHandler errorHandler = new ErrorHandler("Comment does not exist");
                return errorHandler.getErrorResponse();
            }

    }


    public ResponseEntity<Object> updateComment(UpdateCommentRequest request)
    {

            Optional<Comment> optionalComment= commentRepo.findById(request.getCommentID());

            if (optionalComment.isEmpty())
            {
               ErrorHandler errorHandler = new ErrorHandler("Comment does not exist");
                return errorHandler.getErrorResponse();
            }
            else
            {
                Comment comment = optionalComment.get();
                comment.setCommentBody(request.getCommentBody());
                commentRepo.save(comment);
                return new ResponseEntity<>("Comment edited successfully", HttpStatus.OK);
            }
    }


    public ResponseEntity<Object> deleteComment( DeleteCommentRequest deleteCommentRequest)
    {
            Optional<Comment> myComment=commentRepo.findById(deleteCommentRequest.getCommentID());
            if (myComment.isEmpty())
            {
                ErrorHandler errorHandler = new ErrorHandler("Comment does not exist");
                return errorHandler.getErrorResponse();
            }
            else {
                commentRepo.deleteById(deleteCommentRequest.getCommentID());
                return new ResponseEntity<>("Comment deleted successfully", HttpStatus.OK);
            }


    }
}
