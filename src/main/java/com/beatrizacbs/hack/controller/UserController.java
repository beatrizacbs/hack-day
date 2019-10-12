package com.beatrizacbs.hack.controller;

import com.beatrizacbs.hack.model.Child;
import com.beatrizacbs.hack.model.Parent;
import com.beatrizacbs.hack.model.User;
import com.beatrizacbs.hack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/parent")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity createUser(@RequestBody Parent user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/child")
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity createUser(@RequestBody Child user){
        User createdUser = userService.createUser(user);
        return ResponseEntity.ok(createdUser);
    }

}
