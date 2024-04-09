package org.nailproject.controllers;

import lombok.AllArgsConstructor;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.nailproject.services.designServiceJPA.AddDesignServiceJPA;
import org.nailproject.services.designServiceJPA.GetAllDesignServiceByClientIdJPA;

import org.nailproject.services.designServiceJPA.GetOneDesignByNameServiceJPA;
import org.nailproject.services.designServiceJPA.RemoveDesignServiceJPA;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/designs")
public class DesignControllerJPA {
    private final AddDesignServiceJPA addDesignServiceJPA;
    private final GetAllDesignServiceByClientIdJPA getAllDesignServiceByClientIdJPA;
    private final GetOneDesignByNameServiceJPA getOneDesignByNameServiceJPA;
    private final RemoveDesignServiceJPA removeDesignServiceJPA;

    @GetMapping("/{clientId}")
    public List<NailDesign> getAllDesignsByCl(@PathVariable Integer clientId) {
        return getAllDesignServiceByClientIdJPA.getAllDesignsById(clientId);
    }

//    @GetMapping("/random")
//    public Optional<NailDesign> getOneRandomDesignAI(@RequestParam("tags") String tagsString) {
//        return getRandomDesignAIService.getRandomDesignAI(tagsString);
//    }

    @GetMapping("/name")
    public Optional<NailDesign> getOneDesignByName(@RequestParam("inputData") String data) {
        return getOneDesignByNameServiceJPA.getOneDesignByName(data);
    }

    @PostMapping("/addNewDesign")
    public Boolean addDesign(@RequestBody NailDesignClientRequestDTO request) {
        return addDesignServiceJPA.addNailDesign(request);
    }

    @DeleteMapping("/{designId}")
    public Boolean deleteDesign(@PathVariable Integer designId) {
        return removeDesignServiceJPA.removeDesignById(designId);
    }
}
