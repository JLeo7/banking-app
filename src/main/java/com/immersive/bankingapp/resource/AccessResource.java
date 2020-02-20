package com.immersive.bankingapp.resource;

import com.immersive.bankingapp.model.User;
import com.immersive.bankingapp.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class AccessResource {
    private UserService userService;

    public AccessResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user ) {
        User savedUser = this.userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/sign-in")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        user = this.userService.findUserByEmailAndPassword(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
