package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.Level;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ILevelService {

    public Level createLevel(Level level);

    public List<Level> getAllLevels();

    public Level getLevelByNumber(Integer number);
}
