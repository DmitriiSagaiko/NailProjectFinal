package org.nailproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.nailproject.dto.design.DesignRequestDTO;
import org.nailproject.dto.design.DesignResponseDTO;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.requestDTO.NailDesignClientRequestDTO;
import org.nailproject.services.designServiceJPA.AddDesignServiceJPA;
import org.nailproject.services.designServiceJPA.GetAllDesignServiceByClientIdJPA;

import org.nailproject.services.designServiceJPA.GetOneDesignByNameServiceJPA;
import org.nailproject.services.designServiceJPA.RemoveDesignServiceJPA;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Operation(summary = "get users designs by user ID")
    @ApiResponse(responseCode = "200", description = "design has been got successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = DesignResponseDTO.class))})
    @GetMapping("/{clientId}")
    public ResponseEntity<List<DesignResponseDTO>> getAllDesignsByClientId(@PathVariable Integer clientId) {
        return new ResponseEntity<>(getAllDesignServiceByClientIdJPA.getAllDesignsById(clientId), HttpStatus.OK);
    }



    @Operation(summary = "get design by name")
    @ApiResponse(responseCode = "200", description = "design has been got successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class))})
    @GetMapping("/name")
    public ResponseEntity<List<DesignResponseDTO>> getListOfDesignsByName(@RequestParam("inputData") String name) {
        return new ResponseEntity<>(getOneDesignByNameServiceJPA.getOneDesignByName(name), HttpStatus.OK);
    }


    @Operation(summary = "add design to DB")
    @ApiResponse(responseCode = "201", description = "design has been uploaded to DB",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = DesignResponseDTO.class))})
    @PostMapping("/addNewDesign")
    public ResponseEntity<DesignResponseDTO> addDesign(@RequestBody DesignRequestDTO request) {
        return new ResponseEntity<>(addDesignServiceJPA.addNailDesign(request), HttpStatus.CREATED);
    }


    @Operation(summary = "delete design by design ID")
    @ApiResponse(responseCode = "200", description = "design has been deleted successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = DesignResponseDTO.class))})
    @DeleteMapping("/{designId}")
    public ResponseEntity<DesignResponseDTO> deleteDesignById(@PathVariable Integer designId) {
        return new ResponseEntity<>(removeDesignServiceJPA.removeDesignById(designId), HttpStatus.OK);
    }
}
