package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    public User createUser(User user);
}
