package org.nailproject.repository;

import org.nailproject.entity.client.Client;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository {
    //TODO create the DataBase for clients
    public Optional<Client> addClient (Client client) {
        //TODO go to DB, check the usersEmail if it exists there, return empty Optional

        return Optional.empty();
    }

    public Boolean updateClient(Client client) {
        /*
        TODO
        find Client id DB
        If Exist, update Information in DB + return true
        else return false
         */
        return false;
    }

    public Optional<Client> getClientByEmail(String email) {
        /*
        TODO
        Scan all DB, find client,
        if it is there (return it)
        else return emptyOptional
         */
        return Optional.empty();
    }

    public List<Client> getAllClients() {
        //TODO copy all DB and return it
        return Collections.emptyList();
    }
    public Optional<Client> removeClient(String email) {
        /*
        TODO look client, if exist delete it from DB and return this client
        else return empty Optional
         */
        return Optional.empty();
    }


}
