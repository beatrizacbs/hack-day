package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.Dream;
import org.springframework.stereotype.Service;

@Service
public interface IDreamService {

    public Dream create(Dream dream);
}
