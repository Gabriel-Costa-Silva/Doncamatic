package br.com.doncamatic.Doncamatic.controllers;


import br.com.doncamatic.Doncamatic.models.User;
import br.com.doncamatic.Doncamatic.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User>createUser(@RequestBody User user) {
        try {
            userService.create(user);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
