package org.nailproject.services.controllers.design;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.nailproject.controllers.DesignControllerJPA;
import org.nailproject.dto.design.DesignRequestDTO;
import org.nailproject.dto.design.DesignResponseDTO;
import org.nailproject.services.designServiceJPA.AddDesignServiceJPA;
import org.nailproject.services.designServiceJPA.GetAllDesignServiceByClientIdJPA;
import org.nailproject.services.designServiceJPA.GetListOfDesignsByNameServiceJPA;
import org.nailproject.services.designServiceJPA.RemoveDesignServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DesignControllerJPA.class)

public class DesignControllerGoodTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private AddDesignServiceJPA addDesignServiceJPA;
    @MockBean
    private GetAllDesignServiceByClientIdJPA getAllDesignServiceByClientIdJPA;
    @MockBean
    private GetListOfDesignsByNameServiceJPA getListOfDesignsByNameServiceJPA;
    @MockBean
    private RemoveDesignServiceJPA removeDesignServiceJPA;

    DesignResponseDTO designResponseDTO;
    String responseBody;

    Integer designId;
    String name;
    Integer clientId;
    Boolean isPublic;
    Integer amountOfStickers;

    @BeforeEach
    public void setUp() throws Exception {

        designId = 100;
        name = "Test Design";
        clientId = 5;
        isPublic = true;
        amountOfStickers = 7;


        designResponseDTO = new DesignResponseDTO();
        designResponseDTO.setDesignId(designId);
        designResponseDTO.setName(name);
        designResponseDTO.setAmountOfStickers(amountOfStickers);
        designResponseDTO.setIsPublic(isPublic);
        designResponseDTO.setClientId(clientId);

        responseBody = String.format("{\"designId\": \"%d\", \"designName\": \"%s\", \"amountOfStickers\": %d, \"isPublic\": %s, \"clientId\": %d}", designId, name, amountOfStickers, isPublic, clientId);

    }

    @Test
    public void addDesignServiceTest() throws Exception {

        when(addDesignServiceJPA.addNailDesign(any(DesignRequestDTO.class))).thenReturn(designResponseDTO);

        mvc.perform(post("/designs/addNewDesign")
                        .contentType(MediaType.APPLICATION_JSON).content(responseBody))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.designId").value(designId))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amountOfStickers").value(amountOfStickers))
                .andExpect(jsonPath("$.isPublic").value(isPublic))
                .andExpect(jsonPath("$.clientId").value(clientId));


    }

    @Test
    public void getAllDesignServiceTest() throws Exception {
        List<DesignResponseDTO> designResponseDTOList = new ArrayList<>();
        designResponseDTOList.add(designResponseDTO);
        when(getAllDesignServiceByClientIdJPA.getAllDesignsById(anyInt())).thenReturn(designResponseDTOList);

        mvc.perform(get("/designs/{clientId}", clientId).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}]")); // Проверяем, что вернулся массив с одним объектом
    }

    @Test
    public void getListOfDesignsByName() throws Exception {
        List<DesignResponseDTO> designResponseDTOList = new ArrayList<>();
        designResponseDTOList.add(designResponseDTO);

        when(getListOfDesignsByNameServiceJPA.getOneDesignByName(anyString())).thenReturn(designResponseDTOList);

        mvc.perform(get("/designs/name").param("inputData", name).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{}]"));
    }

    @Test
    public void removeDesignServiceTest() throws Exception {
        when(removeDesignServiceJPA.removeDesignById(designId)).thenReturn(designResponseDTO);
        mvc.perform(delete("/designs/{designId}", designId).accept(MediaType.APPLICATION_JSON).content(responseBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.designId").value(designId))
                .andExpect(jsonPath("$.name").value(name))
                .andExpect(jsonPath("$.amountOfStickers").value(amountOfStickers))
                .andExpect(jsonPath("$.isPublic").value(isPublic))
                .andExpect(jsonPath("$.clientId").value(clientId));
    }


}
