package com.beatrizacbs.hack.service.auth;

import com.beatrizacbs.hack.model.Child;
import com.beatrizacbs.hack.model.Login;
import com.beatrizacbs.hack.model.Parent;
import com.beatrizacbs.hack.model.User;
import com.beatrizacbs.hack.repository.IChildRepository;
import com.beatrizacbs.hack.repository.IParentRepository;
import com.beatrizacbs.hack.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private IParentRepository parentRepository;

    @Autowired
    private IChildRepository childRepository;

    @Override
    public User login(Login login) throws IOException {
        Child child = childRepository.findByEmail(login.getEmail());
        Parent parent = parentRepository.findByEmail(login.getEmail());

        if(child == null && parent != null){
            return parent;
        }else if (child != null && parent == null){
            return child;
        }else {
            throw new IOException("Usuário não encontrado");
        }
    }
}
