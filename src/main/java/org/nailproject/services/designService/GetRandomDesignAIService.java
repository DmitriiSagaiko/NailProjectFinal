package org.nailproject.services.designService;

import org.nailproject.annotation.CarlosPayAttention;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.entity.nail.NailTag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetRandomDesignAIService {

    @CarlosPayAttention(whatToDo = "need to find how to manage this method, do we need a rep or not? and etc")
    public Optional<NailDesign> getRandomDesignAI(String tags) {
        //TODO make a request for AI
        //optional because we can not grant the 100% result
        return Optional.empty();
    }
}
