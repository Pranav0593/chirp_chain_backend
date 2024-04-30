package com.example.oop.Controllers;

import com.example.oop.Requests.CreateCommentRequest;
import com.example.oop.Requests.DeleteCommentRequest;
import com.example.oop.Requests.UpdateCommentRequest;
import com.example.oop.Services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Object> createComment(@RequestBody CreateCommentRequest requestToCreateComment)
    {
        return commentService.createComment(requestToCreateComment);
    }

    @GetMapping
    public ResponseEntity<Object> getCommentDetails(@RequestParam Integer commentID)
    {
        return commentService.getCommentDetails(commentID);
    }

    @PatchMapping
    public ResponseEntity<Object> updateComment(@RequestBody UpdateCommentRequest requestToUpdateComment)
    {
        return commentService.updateComment(requestToUpdateComment);
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteComment(@RequestBody DeleteCommentRequest deleteCommentRequest)
    {
        return commentService.deleteComment(deleteCommentRequest);
    }


}
