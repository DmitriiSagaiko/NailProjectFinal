package org.nailproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.nailproject.dto.clients.ClientRequestForUpdateOrCreateDTO;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientControllerJPA {

    private final AddClientServiceJPA addClientServiceJPA;
    private final GetAllClientsServiceJPA getAllClientsServiceJPA;
    private final GetClientByEmailServiceJPA getClientByEmailServiceJPA;
    private final RemoveClientServiceJPA removeClientByEmailJPA;
    private final UpdateClientServiceJPA updateClientServiceJPA;



    @GetMapping("/{email}")
    @Operation(summary = "get a one user by email")
    @ApiResponse(responseCode = "200", description = "Successfully got a client",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClientsResponseDTO.class))})
    public ResponseEntity<ClientsResponseDTO> getClientByEmail(@PathVariable String email) {
        return new ResponseEntity<>(getClientByEmailServiceJPA.getClientByEmail(email), HttpStatus.OK);
    }


    @GetMapping
    @Operation(summary = "get a list of all users")
    @ApiResponse(responseCode = "200", description = "Successfully got a list",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class))})
    public ResponseEntity<List<ClientsResponseDTO>> getAllClients() {
        return new ResponseEntity<>(getAllClientsServiceJPA.getAllClients(), HttpStatus.OK);
    }


    @Operation(summary = "add user to a DB")
    @ApiResponse(responseCode = "201", description = "user was added successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClientsResponseDTO.class))})
    @PostMapping("/addNewClient")
    public ResponseEntity<ClientsResponseDTO> addClient(@Valid @RequestBody ClientRequestForUpdateOrCreateDTO request) {
        return new ResponseEntity<>(addClientServiceJPA.addClient(request), HttpStatus.CREATED);
    }


    @Operation(summary = "update users info by id in DB")
    @ApiResponse(responseCode = "200", description = "user was updated successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClientsResponseDTO.class))})
    @PutMapping("/update")
    public ResponseEntity<ClientsResponseDTO> updateClient(@Valid @RequestBody ClientRequestForUpdateOrCreateDTO request) {
        return new ResponseEntity<>(updateClientServiceJPA.updateClient(request), HttpStatus.OK);
    }


    @Operation(summary = "delete user from DB")
    @ApiResponse(responseCode = "200", description = "user was deleted successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = ClientsResponseDTO.class))})
    @DeleteMapping("/{email}")
    @Transactional
    public ResponseEntity<ClientsResponseDTO> deleteClient(@PathVariable String email) {
        return new ResponseEntity<>(removeClientByEmailJPA.removeClientByEmail(email), HttpStatus.OK);
    }







}


