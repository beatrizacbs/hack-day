package com.beatrizacbs.hack.service.user;

import com.beatrizacbs.hack.model.User;
import com.beatrizacbs.hack.repository.IUserRepository;
import com.beatrizacbs.hack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
}
