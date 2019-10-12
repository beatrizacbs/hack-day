package com.beatrizacbs.hack.controller;

import com.beatrizacbs.hack.model.Login;
import com.beatrizacbs.hack.service.IAuthService;
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
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/login")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity login(@RequestBody Login login){
        return ResponseEntity.ok(authService.login(login));
    }

}

