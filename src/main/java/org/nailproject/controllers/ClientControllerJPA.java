package org.nailproject.controllers;

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


    @GetMapping(value = "/{email}")
    public Optional<Client> getClientByEmail (@PathVariable String email) {
        return getClientByEmailServiceJPA.getClientByEmail(email);
    }

    @GetMapping
    public List<Client> getAllClients () {
        return getAllClientsServiceJPA.getAllClients();
    }

    @PostMapping("/addNewClient")
    public Boolean addClient(@RequestBody Client client){
        return addClientServiceJPA.addClient(client);
    }

    @PutMapping("/update")
    public Boolean updateClient(@RequestBody Client client) {
        return updateClientServiceJPA.updateClient(client);
    }

    @DeleteMapping("/{email}")
    @Transactional
    public Boolean deleteClient(@PathVariable String email) {
        return removeClientByEmailJPA.removeClientByEmail(email);
    }


}


