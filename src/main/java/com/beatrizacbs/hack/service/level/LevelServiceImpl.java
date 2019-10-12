package com.beatrizacbs.hack.service.level;

import com.beatrizacbs.hack.model.Level;
import com.beatrizacbs.hack.repository.ILevelRepository;
import com.beatrizacbs.hack.service.ILevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements ILevelService {

    @Autowired
    public ILevelRepository levelRepository;

    @Override
    public Level createLevel(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public List<Level> getAllLevels() {
        return levelRepository.findAll();
    }

    @Override
    public Level getLevelByNumber(Integer number) {
        return levelRepository.findByLevelNumber(number);
    }
}
