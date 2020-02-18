package com.immersive.bankingapp.resource;

import com.immersive.bankingapp.model.User;
import com.immersive.bankingapp.service.UserService;
import com.immersive.bankingapp.utils.JWTAuthHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/user")
public class UserResource {
    private UserService userService;
    private JWTAuthHelper jwtAuthHelper;

    public UserResource(UserService userService, JWTAuthHelper jwtAuthHelper) {
        this.userService = userService;
        this.jwtAuthHelper = jwtAuthHelper;
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

    @GetMapping("/sign-in")
    public ResponseEntity<User> findById(@RequestBody User user) {
        user = this.userService.findUserByEmailAndPassword(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
