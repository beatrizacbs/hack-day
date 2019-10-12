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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/parent")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createParent(@Valid @RequestBody Parent user){
        User createdUser = null;
        try {
            createdUser = userService.createUser(user);
            return ResponseEntity.ok(createdUser);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/child")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createChild(@Valid @RequestBody Child user){
        User createdUser = null;
        try {
            createdUser = userService.createUser(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/child/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getChildById(@PathVariable(value = "id") String id){
        try {
            return ResponseEntity.ok(userService.getUser("CHILD", id));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }


}
