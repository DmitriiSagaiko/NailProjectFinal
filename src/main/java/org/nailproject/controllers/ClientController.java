//package org.nailproject.controllers;
//
//import lombok.AllArgsConstructor;
//import org.nailproject.entity.client.Client;
//import org.nailproject.services.clientService.*;
//import org.nailproject.services.clientServiceJPA.GetAllClientsServiceJPA;
//import org.springframework.context.annotation.Conditional;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController()
//@AllArgsConstructor
//@RequestMapping("/clients")
//public class ClientController {
//    private final AddClientService addClientService;
//    private final GetAllClientsService getAllClientsService;
//    private final GetClientByEmailService getClientByEmailService;
//    private final RemoveClientService removeClientService;
//    private final UpdateClientService updateClientService;
//    private final GetAllClientsServiceJPA getAllClientsServiceJPA;
//
//    @GetMapping(value = "/{email}")
//    public Optional<Client> getClientByEmail (@PathVariable String email) {
//        return getClientByEmailService.getClientByEmail(email);
//    }
//
//    @GetMapping
//    public List<Client> getAllClients () {
//        return getAllClientsServiceJPA.getAllClients();
//    }
//
//    @PostMapping("/addNewClient")
//    public Boolean addClient(@RequestBody Client client){
//        return addClientService.addClient(client);
//    }
//
//    @PutMapping("/update")
//    public Boolean updateClient(@RequestBody Client client) {
//        return updateClientService.updateClient(client);
//    }
//
//    @DeleteMapping("/{email}")
//    public Boolean deleteClient(@PathVariable String email) {
//        return removeClientService.removeClientByEmail(email);
//    }
//
//
//}
