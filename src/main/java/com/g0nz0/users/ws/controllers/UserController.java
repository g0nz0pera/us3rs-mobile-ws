package com.g0nz0.users.ws.controllers;

import com.g0nz0.users.ws.controllers.HttpRequests.UserRequest;
import com.g0nz0.users.ws.controllers.HttpResponses.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path = "/{userId}")
    public ResponseEntity<UserResponse> getUser(@PathVariable String userId){
        UserResponse user = new UserResponse();
        user.setUserId("1");
        user.setFirstName("batman");
        return new ResponseEntity<UserResponse>(user,HttpStatus.OK);
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page") long page,
                           @RequestParam(value = "limit") long limit){
        return "Getting the user with the userId " + page;
    }


    @PostMapping(consumes = {
            MediaType.APPLICATION_JSON_VALUE
    },
    produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserRequest newUser){
        UserResponse user = new UserResponse();
        user.setEmail(newUser.getEmail());
        user.setFirstName(newUser.getFirstName());
        return new ResponseEntity<UserResponse>(user,HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
            },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<UserResponse> updateUser(@PathVariable String userId, @Valid @RequestBody UserRequest userDetails){

        return new ResponseEntity<>(new UserResponse(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId){
        return ResponseEntity.noContent().build();
    }
}
