package com.beatrizacbs.hack.service.auth;

import com.beatrizacbs.hack.model.Login;
import com.beatrizacbs.hack.model.User;
import com.beatrizacbs.hack.repository.IUserRepository;
import com.beatrizacbs.hack.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User login(Login login) {
        return userRepository.findByEmail(login.getEmail());
    }
}
