package br.com.doncamatic.Doncamatic.controllers;


import br.com.doncamatic.Doncamatic.controllers.requests.CreateUserRequest;
import br.com.doncamatic.Doncamatic.controllers.requests.LoginRequest;
import br.com.doncamatic.Doncamatic.controllers.responses.TokenResponse;
import br.com.doncamatic.Doncamatic.models.User;
import br.com.doncamatic.Doncamatic.security.TokenService;
import br.com.doncamatic.Doncamatic.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<> login  (@RequestBody @Valid LoginRequest loginRequest){

        try {
            UsernamePasswordAuthenticationToken senha = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.senha());
            Authentication auth = this.authenticationManager.authenticate(senha);

            String  token = tokenService.generateToken((User) auth.getPrincipal());

            return new ResponseEntity<>(new  TokenResponse(token), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping("/register")
    public ResponseEntity<User>createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        try {
            User user = userService.create(createUserRequest);
            return new ResponseEntity<User>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
