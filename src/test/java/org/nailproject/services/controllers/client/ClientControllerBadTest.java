package org.nailproject.services.controllers.client;

import exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.nailproject.controllers.ClientControllerJPA;
import org.nailproject.dto.clients.ClientRequestForUpdateOrCreateDTO;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClientControllerJPA.class)
@ExtendWith(MockitoExtension.class)
public class ClientControllerBadTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AddClientServiceJPA addClientService;
    @MockBean
    GetAllClientsServiceJPA getAllClientsService;
    @MockBean
    GetClientByEmailServiceJPA getClientByEmailServiceJPA;
    @MockBean
    RemoveClientServiceJPA removeClientService;
    @MockBean
    UpdateClientServiceJPA updateClientService;



    @Test
    public void addBadClient() throws Exception {

        //TODO
    }

    @Test
    public void findBadClientNPE() throws Exception {
        when(getClientByEmailServiceJPA.getClientByEmail("test")).thenThrow(NullPointerException.class);

        mockMvc.perform(get("/clients/{email}", "test").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(result -> assertInstanceOf(NullPointerException.class, result.getResolvedException()));

    }

    @Test
    public void findBadClientNotFound() throws Exception {
        when(getClientByEmailServiceJPA.getClientByEmail("test")).thenThrow(NotFoundException.class);
        mockMvc.perform(get("/clients/{email}", "test").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void deleteBadClientNullPointer() throws Exception {
        when(removeClientService.removeClientByEmail(anyString())).thenThrow(NullPointerException.class);
        mockMvc.perform(delete("/clients/{email}", "test").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(result -> assertInstanceOf(NullPointerException.class, result.getResolvedException()));

    }

    @Test
    public void deleteBadClientNotFound() throws Exception {

        when(removeClientService.removeClientByEmail(anyString())).thenThrow(NotFoundException.class);
        mockMvc.perform(delete("/clients/{email}", "test").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()));
    }





}
