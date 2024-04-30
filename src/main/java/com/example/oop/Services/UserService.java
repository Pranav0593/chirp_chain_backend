package com.example.oop.Services;

import com.example.oop.Entities.AppUser;
import com.example.oop.ErrorHandler;
import com.example.oop.Entities.Post;
import com.example.oop.Repository.PostRepository;
import com.example.oop.Repository.UserRepository;
import com.example.oop.Requests.LoginRequest;
import com.example.oop.Requests.SignupRequest;
import com.example.oop.Responses.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository)
    {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }


    public ResponseEntity<?> login(LoginRequest request)
    {

        Optional<AppUser> appUser=userRepository.findByEmail(request.getEmail());
        if (appUser.isEmpty())
        {
            ErrorHandler errorHandler = new ErrorHandler("User does not exist");
            return errorHandler.getErrorResponse();
        }
        else if (appUser.get().getPassword().equals(request.getPassword()))
        {
            return new ResponseEntity<>("Login Successful", HttpStatus.OK);
        }
        else
        {
            ErrorHandler errorHandler = new ErrorHandler("Username/Password Incorrect");
            return errorHandler.getErrorResponse();
        }

    }

    public ResponseEntity<Object> signup( SignupRequest request)
    {
        Optional<AppUser> user = userRepository.findByEmail(request.getEmail());
        if (user.isPresent())
        {
           ErrorHandler errorHandler = new ErrorHandler("Forbidden, Account already exists");
              return errorHandler.getErrorResponse();
        }
        AppUser newAppUser = new AppUser(request.getEmail(), request.getName(), request.getPassword());
        userRepository.save(newAppUser);
        return new ResponseEntity<>("Account Creation Successful", HttpStatus.CREATED);

    }


    public ResponseEntity<Object> getUserDetails(Integer userId)
    {
        Optional<AppUser> user = userRepository.findById(userId);
        if (user.isEmpty())
        {
            ErrorHandler errorHandler = new ErrorHandler("User does not exist");
            return errorHandler.getErrorResponse();
        }
        AppUser appUser = user.get();
        UserDetailResponse userDetailResponse = new UserDetailResponse(appUser.getName(), appUser.getId(), appUser.getEmail());
        return new ResponseEntity<>(userDetailResponse, HttpStatus.OK);

    }


    public ResponseEntity<List<Post>> getUserFeed()
    {

        Iterable<Post> posts = postRepository.findAll();
        List<Post> postList=(List<Post>) posts;

        //sort based on postID in descending order

        postList.sort((post1, post2) -> post2.getPostID().compareTo(post1.getPostID()));
        return new ResponseEntity<>(postList, HttpStatus.OK);

    }


    public ResponseEntity<List<?>> getAllUsers()
    {
        Iterable<AppUser> users = userRepository.findAll();
        List<AppUser> appUserList = (List<AppUser>) users;
        List<UserDetailResponse> userList=new ArrayList<>();
        for (AppUser appUser:appUserList)
        {
            UserDetailResponse userDetailResponse=new UserDetailResponse(appUser.getName(),appUser.getId(),appUser.getEmail());
            userList.add(userDetailResponse);
        }
       return new ResponseEntity<>(userList, HttpStatus.OK);
    }



}