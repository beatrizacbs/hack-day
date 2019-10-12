package com.beatrizacbs.hack.service;

import com.beatrizacbs.hack.model.Login;
import com.beatrizacbs.hack.model.User;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IAuthService {

    public User login(Login login) throws IOException;

}
