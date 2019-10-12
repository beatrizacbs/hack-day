package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IUserService {

    public User createUser(User user) throws IOException;
}
