package org.nailproject.services.designService;

import org.nailproject.entity.nail.NailDesign;
import org.nailproject.entity.nail.NailTag;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetRandomDesignAIService {
    public Optional<NailDesign> getRandomDesignAI(List<NailTag> list) {
        //TODO make a request for AI
        //optional because we can not grant the 100% result
        return Optional.empty();
    }
}
