package com.immersive.bankingapp.resource;

import com.immersive.bankingapp.model.User;
import com.immersive.bankingapp.service.UserService;
import com.immersive.bankingapp.utils.JWTAuthHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("api/")
public class AccessResource {
    private UserService userService;
    private JWTAuthHelper jwtAuthHelper;

    public AccessResource(UserService userService, JWTAuthHelper jwtAuthHelper) {
        this.userService = userService;
        this.jwtAuthHelper = jwtAuthHelper;
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody User user) {
        User savedUser = this.userService.save(user);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @PostMapping("sign-in")
    public ResponseEntity<User> signIn(@RequestBody User user) {
        user = this.userService.findUserByEmailAndPassword(user);
        if (user != null) {
            user.setToken(jwtAuthHelper.createToken("email", user.getEmail()));
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);

    }
}
