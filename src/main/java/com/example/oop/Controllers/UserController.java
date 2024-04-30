package com.example.oop.Controllers;

import com.example.oop.Entities.Post;
import com.example.oop.Requests.LoginRequest;
import com.example.oop.Requests.SignupRequest;
import com.example.oop.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{
    private final UserService userService;

    @Autowired
    public UserController(UserService userService)
    {

        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request)
    {

        return userService.login(request);
    }

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody SignupRequest request)
    {

        return userService.signup(request);
    }

    @GetMapping("/user")
    public ResponseEntity<Object> getUserDetails(@RequestParam("userID") Integer userID)
    {
        return userService.getUserDetails(userID);
    }

    @GetMapping("/")
    public ResponseEntity<List<Post>> getUserFeed()
    {

        return userService.getUserFeed();
    }

    @GetMapping("/users")
    public ResponseEntity<List<?>> getAllUsers()
    {
        return userService.getAllUsers();
    }


}
