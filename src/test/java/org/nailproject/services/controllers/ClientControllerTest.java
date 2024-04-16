package org.nailproject.services.controllers;

import org.junit.jupiter.api.Test;
import org.nailproject.controllers.ClientControllerJPA;
import org.nailproject.dto.clients.ClientRequestForUpdateOrCreateDTO;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientControllerJPA.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    AddClientServiceJPA addClientService;
    @MockBean
    FindClientByIdServiceJPA findClientService;
    @MockBean
    GetAllClientsServiceJPA getAllClientsService;
    @MockBean
    GetClientByEmailServiceJPA getClientByEmailServiceJPA;
    @MockBean
    RemoveClientServiceJPA removeClientService;
    @MockBean
    UpdateClientServiceJPA updateClientService;

    @Test
    public void testAddClient() throws Exception {
        ClientsResponseDTO responseDTO = new ClientsResponseDTO();
        responseDTO.setEmail("test@test.com");
        responseDTO.setFirstName("TestFirstName");
        responseDTO.setLastName("TestLastName");
        responseDTO.setId(100);
        responseDTO.setPhoneNumber("+49123456789");

        when(addClientService.addClient(any(ClientRequestForUpdateOrCreateDTO.class))).thenReturn(responseDTO);

        String response = "{\"email\":\"test@test.com\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"id\":100, \"phoneNumber\":\"+49123456789\"}";

        mockMvc.perform(post("/clients/addNewClient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(response))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.email").value("test@test.com"))
                .andExpect(jsonPath("$.firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.lastName").value("TestLastName"))
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.phoneNumber").value("+49123456789"));

    }



}
