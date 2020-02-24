package com.immersive.bankingapp.resource;

import com.immersive.bankingapp.model.User;
import com.immersive.bankingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserResource {
    private UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user ) {
        User savedUser = this.userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List> findAll() {
        List<User> users = this.userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findById(@PathVariable int userId) {
        User user = this.userService.findUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<User> findById(@PathVariable int userId, @RequestHeader("jwt") String jwt) {
//        User user = this.userService.findUserById(userId);
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
}
