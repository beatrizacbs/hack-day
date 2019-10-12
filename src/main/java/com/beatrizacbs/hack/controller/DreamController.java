package com.beatrizacbs.hack.controller;

import com.beatrizacbs.hack.model.Dream;
import com.beatrizacbs.hack.service.IDreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@Controller
@RequestMapping("/api/dream")
public class DreamController {

    @Autowired
    public IDreamService dreamService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createDream(@Valid @RequestBody Dream dream){
        return ResponseEntity.ok(dreamService.create(dream));
    }
}
