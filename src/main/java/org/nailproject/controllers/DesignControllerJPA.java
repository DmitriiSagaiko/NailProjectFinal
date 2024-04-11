package org.nailproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(summary = "get users design by ID")
    @ApiResponse(responseCode = "200", description = "design has been got successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class))})
    @GetMapping("/{clientId}")
    public List<NailDesign> getAllDesignsByCl(@PathVariable Integer clientId) {
        return getAllDesignServiceByClientIdJPA.getAllDesignsById(clientId);
    }

//    @GetMapping("/random")
//    public Optional<NailDesign> getOneRandomDesignAI(@RequestParam("tags") String tagsString) {
//        return getRandomDesignAIService.getRandomDesignAI(tagsString);
//    }

    @Operation(summary = "get design by name")
    @ApiResponse(responseCode = "200", description = "design has been got successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Optional.class))})
    @GetMapping("/name")
    public Optional<NailDesign> getOneDesignByName(@RequestParam("inputData") String data) {
        return getOneDesignByNameServiceJPA.getOneDesignByName(data);
    }


    @Operation(summary = "add design to DB")
    @ApiResponse(responseCode = "201", description = "design has been uploaded to DB",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class))})
    @PostMapping("/addNewDesign")
    public Boolean addDesign(@RequestBody NailDesignClientRequestDTO request) {
        return addDesignServiceJPA.addNailDesign(request);
    }


    @Operation(summary = "delete design by ID")
    @ApiResponse(responseCode = "200", description = "design has been deleted successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class))})
    @DeleteMapping("/{designId}")
    public Boolean deleteDesign(@PathVariable Integer designId) {
        return removeDesignServiceJPA.removeDesignById(designId);
    }
}
