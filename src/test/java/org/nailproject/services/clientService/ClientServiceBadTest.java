package org.nailproject.services.clientService;

import exceptions.AlreadyExistException;
import exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.nailproject.dto.clients.ClientRequestForUpdateOrCreateDTO;
import org.nailproject.entity.client.Client;
import org.nailproject.repository.ClientRepositoryJPA;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ClientServiceBadTest {
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
    @InjectMocks
    FindClientByIdServiceJPA findClientByIdServiceJPA;

    @Mock
    ClientRequestForUpdateOrCreateDTO clientRequestForUpdateOrCreateDTO;

    Client client = new Client("testName", "testSurname", 18 ,"test@test.com", "phone", 1, Collections.emptyList());
    ClientRequestForUpdateOrCreateDTO createDTO = new ClientRequestForUpdateOrCreateDTO("testName", "testSurname", 18 ,"test@test.com", "phone", 1);

    @Test
    public void addBadClientTest() {
        when(clientRepositoryJPA.getClientByEmail(anyString())).thenReturn(Optional.of(client));
       assertThrows(AlreadyExistException.class, () -> addClientServiceJPA.addClient(createDTO));
    }

    @Test
    public void findClientWithBadIdTest() {
        when(clientRepositoryJPA.findById(anyString())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, ()-> findClientByIdServiceJPA.findOptionalClientById(5));
    }

    @Test
    public void GetAllClientsEmptyListServiceJPATest(){
        when(clientRepositoryJPA.findAll()).thenReturn(Collections.emptyList());
        assertTrue(clientRepositoryJPA.findAll().isEmpty());
    }

    @Test
    public void getClientWithBadEmailServiceTest() {
        when(clientRepositoryJPA.getClientByEmail(anyString())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, ()-> getClientByEmailServiceJPA.getClientByEmail("Test@email.ru"));
    }

    @Test
    public void removeBadClientTest() {
        when(clientRepositoryJPA.getClientByEmail(anyString())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, ()-> removeClientServiceJPA.removeClientByEmail("Test@test.com"));
    }

    @Test
    public void updateBadClientTest() {
        when(clientRepositoryJPA.findById(anyString())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> updateClientServiceJPA.updateClient(clientRequestForUpdateOrCreateDTO));
    }


}
