package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.Login;
import com.beatrizacbs.hack.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IAuthService {

    public User login(Login login);

}
