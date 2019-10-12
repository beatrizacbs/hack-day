package com.beatrizacbs.hack.controller;

import com.beatrizacbs.hack.model.Login;
import com.beatrizacbs.hack.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@Controller
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity login(@RequestBody Login login){
        try {
            return ResponseEntity.ok(authService.login(login));
        } catch (IOException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }

}

