package org.nailproject.services.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.nailproject.controllers.ClientControllerJPA;
import org.nailproject.dto.clients.ClientRequestForUpdateOrCreateDTO;
import org.nailproject.dto.clients.ClientsResponseDTO;
import org.nailproject.entity.client.Client;
import org.nailproject.services.clientServiceJPA.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(ClientControllerJPA.class)
public class ClientControllerTest {

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


    ClientsResponseDTO clientsResponseDTO = new ClientsResponseDTO();
    String response;

    @BeforeEach
    public void setUp() throws Exception {
        clientsResponseDTO.setEmail("test@test.com");
        clientsResponseDTO.setFirstName("TestFirstName");
        clientsResponseDTO.setLastName("TestLastName");
        clientsResponseDTO.setId(100);
        clientsResponseDTO.setPhoneNumber("+49123456789");
        response = "{\"email\":\"test@test.com\",\"firstName\":\"TestFirstName\",\"lastName\":\"TestLastName\",\"id\":100, \"phoneNumber\":\"+49123456789\"}";
    }

    @Test
    public void testAddClient() throws Exception {


        when(addClientService.addClient(any(ClientRequestForUpdateOrCreateDTO.class))).thenReturn(clientsResponseDTO);


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




    @Test
    public void testGetAllClients() throws Exception {
        List<ClientsResponseDTO> responseDTOs = new ArrayList<>();
        String email = "test";
        String firstName = "TestFirstName";
        String lastName = "TestLastName";
        String phoneNumber = "+49123456789";

        for (int i = 0; i < 10; i++) {
            ClientsResponseDTO responseDTO = new ClientsResponseDTO();
            responseDTO.setEmail(email + i + "@test.com");
            responseDTO.setFirstName(firstName + i);
            responseDTO.setLastName(lastName + i);
            responseDTO.setId(i);
            responseDTO.setPhoneNumber(phoneNumber);
            responseDTOs.add(responseDTO);
        }

        when(getAllClientsService.getAllClients()).thenReturn(responseDTOs);

        for (int i = 0; i < 10; i++) {
            mockMvc.perform(get("/clients").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[" + i + "].email").value(email + i + "@test.com"))
                    .andExpect(jsonPath("$[" + i + "].firstName").value(firstName + i))
                    .andExpect(jsonPath("$[" + i + "].lastName").value(lastName + i))
                    .andExpect(jsonPath("$[" + i + "].id").value(i))
                    .andExpect(jsonPath("$[" + i + "].phoneNumber").value(phoneNumber));
        }


    }

    @Test
    public void testGetClientByEmail() throws Exception {


        when(getClientByEmailServiceJPA.getClientByEmail(any(String.class))).thenReturn(clientsResponseDTO);

        mockMvc.perform(get("/clients/{email}", "test@test.com").contentType(MediaType.APPLICATION_JSON)
                        .content(response))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@test.com"))
                .andExpect(jsonPath("$.firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.lastName").value("TestLastName"))
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.phoneNumber").value("+49123456789"));

    }

    @Test
    public void testRemoveClient() throws Exception {
        when(removeClientService.removeClientByEmail(any(String.class))).thenReturn(clientsResponseDTO);

        mockMvc.perform(delete("/clients/{email}", "test@test.com").contentType(MediaType.APPLICATION_JSON)
                        .content(response))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@test.com"))
                .andExpect(jsonPath("$.firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.lastName").value("TestLastName"))
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.phoneNumber").value("+49123456789"));


    }

    @Test
    public void testUpdateClient() throws Exception {
        when(updateClientService.updateClient(any(ClientRequestForUpdateOrCreateDTO.class))).thenReturn(clientsResponseDTO);

        mockMvc.perform(put("/clients/update", "test@test.com").contentType(MediaType.APPLICATION_JSON).content(response))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("test@test.com"))
                .andExpect(jsonPath("$.firstName").value("TestFirstName"))
                .andExpect(jsonPath("$.lastName").value("TestLastName"))
                .andExpect(jsonPath("$.id").value(100))
                .andExpect(jsonPath("$.phoneNumber").value("+49123456789"));

    }


}
