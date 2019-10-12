package com.beatrizacbs.hack.controller;

import com.beatrizacbs.hack.model.Level;
import com.beatrizacbs.hack.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/level")
public class LevelController {

    @Autowired
    private ILevelService levelService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity createLevel(Level level){
        return ResponseEntity.ok(levelService.createLevel(level));
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllLevels(){
        return ResponseEntity.ok(levelService.getAllLevels());
    }

    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE, value= "/{level-number}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getLevelByNumber(@PathVariable(value = "level-number") Integer levelNumber){
        return ResponseEntity.ok(levelService.getLevelByNumber(levelNumber));
    }

}
