package org.nailproject.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.nailproject.entity.client.Client;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientControllerJPA {

    private final AddClientServiceJPA addClientServiceJPA;
    private final GetAllClientsServiceJPA getAllClientsServiceJPA;
    private final GetClientByEmailServiceJPA getClientByEmailServiceJPA;
    private final RemoveClientServiceJPA removeClientByEmailJPA;
    private final UpdateClientServiceJPA updateClientServiceJPA;


    @GetMapping( "/{email}")
    @Operation(summary = "get a one user by email")
    @ApiResponse(responseCode = "200", description = "Successfully got a client",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Optional.class))})
    public Optional<Client> getClientByEmail(@PathVariable String email) {
        return getClientByEmailServiceJPA.getClientByEmail(email);
    }



    @GetMapping
    @Operation(summary = "get a list of all users")
    @ApiResponse(responseCode = "200", description = "Successfully got a list",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = List.class))})
    public List<Client> getAllClients() {
        return getAllClientsServiceJPA.getAllClients();
    }




    @Operation(summary = "add user to a DB")
    @ApiResponse(responseCode = "201", description = "user was added successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class))})
    @PostMapping("/addNewClient")
    public Boolean addClient(@Valid @RequestBody Client client) {
        return addClientServiceJPA.addClient(client);
    }



    @Operation(summary = "update user id DB")
    @ApiResponse(responseCode = "200", description = "user was updated successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class))})
    @PutMapping("/update")
    public Boolean updateClient(@Valid @RequestBody Client client) {
        return updateClientServiceJPA.updateClient(client);
    }



    @Operation(summary = "delete user from DB")
    @ApiResponse(responseCode = "200", description = "user was deleted successfully",
            content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Boolean.class))})
    @DeleteMapping("/{email}")
    @Transactional
    public Boolean deleteClient(@Valid @PathVariable String email) {
        return removeClientByEmailJPA.removeClientByEmail(email);
    }


}


