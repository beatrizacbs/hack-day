package com.beatrizacbs.hack.service.dream;

import com.beatrizacbs.hack.model.Child;
import com.beatrizacbs.hack.model.Dream;
import com.beatrizacbs.hack.repository.IChildRepository;
import com.beatrizacbs.hack.repository.IDreamRepository;
import com.beatrizacbs.hack.service.IDreamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DreamServiceImpl implements IDreamService {

    @Autowired
    private IDreamRepository dreamRepository;

    @Autowired
    private IChildRepository childRepository;

    @Override
    public Dream create(Dream dream) {
        Optional<Child> childOptional = childRepository.findById(dream.getChildId());
        dreamRepository.save(dream);
        childOptional.ifPresent(child -> {
            if (child.getDreamIds() == null){
                child.setDreamIds(new ArrayList<>());
            }
            child.getDreamIds().add(dream.getId());
            childRepository.save(child);
        });

        return dreamRepository.save(dream);
    }
}
