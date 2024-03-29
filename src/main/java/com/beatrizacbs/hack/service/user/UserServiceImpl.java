package com.beatrizacbs.hack.service.user;

import com.beatrizacbs.hack.model.Child;
import com.beatrizacbs.hack.model.Parent;
import com.beatrizacbs.hack.model.User;
import com.beatrizacbs.hack.repository.IChildRepository;
import com.beatrizacbs.hack.repository.IParentRepository;
import com.beatrizacbs.hack.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    public IChildRepository childRepository;

    @Autowired
    private IParentRepository parentRepository;

    @Override
    public User createUser(User user) throws IOException {
        if (user instanceof Child) {
            childRepository.save((Child) user);
            Optional<Parent> parent = parentRepository.findById(((Child) user).getParentId());
            parent.ifPresent(dbParent -> {
                if (dbParent.childIds == null) {
                    dbParent.childIds = new ArrayList<>();
                }
                dbParent.childIds.add(user.getId());
                parentRepository.save(dbParent);
            });
            return childRepository.save((Child) user);
        } else if (user instanceof Parent) {
            return parentRepository.save((Parent) user);
        } else {
            throw new IOException("Parâmetros inválidos");
        }

    }

    @Override
    public User getUser(String type, String id) throws IOException {
        if (type.equals("CHILD")) {
            Optional<Child> childOptional = childRepository.findById(id);
            if (childOptional.isPresent()) {
                return childOptional.get();
            } else {
                throw new IOException("O usuário não existe");
            }
        } else if (type.equals("PARENT")) {
            Optional<Parent> parentOptional = parentRepository.findById(id);
            if(parentOptional.isPresent()){
                return parentOptional.get();
            }else{
                throw new IOException("O usuário não existe");
            }
        }else {
            throw new IOException("Tipo do usuário não informado");
        }
    }
}
