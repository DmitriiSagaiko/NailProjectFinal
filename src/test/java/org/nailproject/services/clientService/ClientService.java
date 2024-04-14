package org.nailproject.services.clientService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nailproject.dto.clients.ClientRequestForUpdateOrCreateDTO;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ClientService {

    //We dont use @BeforeEach or @BeforeAll because
    //Mock is auto injected into service.

    @Mock
    ClientRepositoryJPA clientRepositoryJPA;
    @InjectMocks
    AddClientServiceJPA addClientServiceJPA;
    @InjectMocks
    GetAllClientsServiceJPA getAllClientsServiceJPA;
    @InjectMocks
    GetClientByEmailServiceJPA getClientByEmailServiceJPA;
    @InjectMocks
    RemoveClientServiceJPA removeClientServiceJPA;
    @InjectMocks
    UpdateClientServiceJPA updateClientServiceJPA;

    @Mock
    ClientRequestForUpdateOrCreateDTO clientRequestForUpdateOrCreateDTO;




    @Test
    void addClientTest() {
        when(clientRepositoryJPA.save(any(Client.class))).thenReturn(new Client());
        addClientServiceJPA.addClient(clientRequestForUpdateOrCreateDTO);
        verify(clientRepositoryJPA, times(1)).save(any(Client.class));
    }

    @Test
    void getAllClientsTest() {
        when(clientRepositoryJPA.findAll()).thenReturn(new ArrayList<>());
        getAllClientsServiceJPA.getAllClients();
        verify(clientRepositoryJPA, times(1)).findAll();
    }

    @Test
    void getClientByEmailTest() {
        when(clientRepositoryJPA.getClientByEmail(any(String.class))).thenReturn(Optional.of(new Client()));
        getClientByEmailServiceJPA.getClientByEmail(anyString());
        verify(clientRepositoryJPA, times(1)).getClientByEmail(anyString());
    }

    @Test
    void removeClientTest() {
        String email = anyString();
        when(clientRepositoryJPA.getClientByEmail(email)).thenReturn(Optional.of(new Client()));
        removeClientServiceJPA.removeClientByEmail(email);
        verify(clientRepositoryJPA, times(1)).delete(any(Client.class));
    }

    @Test
    void updateClientTest() {
        when(clientRepositoryJPA.findById(anyString())).thenReturn(Optional.of(new Client()));
        String clientId = "100";
        clientRequestForUpdateOrCreateDTO.setId(Integer.valueOf(clientId));
        updateClientServiceJPA.updateClient(clientRequestForUpdateOrCreateDTO);
        verify(clientRepositoryJPA, times(1)).save(new Client());
    }

}