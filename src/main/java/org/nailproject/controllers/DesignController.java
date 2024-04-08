package org.nailproject.controllers;


import lombok.AllArgsConstructor;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.nailproject.services.designService.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/designs")
public class DesignController {
    private final AddDesignService addDesignService;
    private final GetAllDesignsService getAllDesignsService;
    private final GetOneDesignByNameService getOneDesignByNameService;
    private final GetRandomDesignAIService getRandomDesignAIService;
    private final PrintDesignService printDesignService;
    private final RemoveDesignService removeDesignService;
    private final ShareDesignService shareDesignService;

    @GetMapping("/{email}")
    public List<NailDesign> getAllDesigns(@PathVariable String email) {
        return getAllDesignsService.getAllDesigns(email);
    }

    @GetMapping("/random")
    public Optional<NailDesign> getOneRandomDesignAI(@RequestParam("tags") String tagsString) {
        return getRandomDesignAIService.getRandomDesignAI(tagsString);
    }

    @GetMapping("/name")
    public Optional<NailDesign> getOneDesignByName(@RequestParam("inputData") String data) {
        return getOneDesignByNameService.getOneDesignByName(data);
    }

    @PostMapping("/addNewDesign")
    public Boolean addDesign(@RequestBody NailDesignClientRequestDTO request) {
        return addDesignService.addNailDesign(request);
    }

    @DeleteMapping("/{request}")
    public Boolean deleteDesign(@PathVariable NailDesignClientRequestDTO request) {
        return removeDesignService.removeDesign(request);
    }

    //TODO printDesign
    //TODO shareDesign


}
