package org.nailproject.services.controllers.design;


import exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.nailproject.controllers.DesignControllerJPA;
import org.nailproject.services.designServiceJPA.AddDesignServiceJPA;
import org.nailproject.services.designServiceJPA.GetAllDesignServiceByClientIdJPA;
import org.nailproject.services.designServiceJPA.GetListOfDesignsByNameServiceJPA;
import org.nailproject.services.designServiceJPA.RemoveDesignServiceJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DesignControllerJPA.class)
public class DesignControllerBadTest {

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



    @Test
    public void addWrongDesignTest() throws Exception {
        //TODO
    }

    @Test
    public void getDesignsByWrongIdNPE() throws Exception {
        when(getAllDesignServiceByClientIdJPA.getAllDesignsById(anyInt())).thenThrow(NullPointerException.class);
        mvc.perform(get("/designs/{clientId}", anyInt()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(result -> assertInstanceOf(NullPointerException.class, result.getResolvedException()));
    }

    @Test
    public void getDesignsByWrongIdIdNotFound() throws Exception {
        when(getAllDesignServiceByClientIdJPA.getAllDesignsById(anyInt())).thenThrow(NotFoundException.class);
        mvc.perform(get("/designs/{clientId}", anyInt()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void getDesignByWrongNameNPE() throws Exception {
        when(getListOfDesignsByNameServiceJPA.getOneDesignByName(anyString())).thenThrow(NullPointerException.class);
        mvc.perform(get("/designs/name").param("inputData", anyString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(result -> assertInstanceOf(NullPointerException.class, result.getResolvedException()));
    }

    @Test
    public void getDesignByWrongNameNotFound() throws Exception {
        when(getListOfDesignsByNameServiceJPA.getOneDesignByName(anyString())).thenThrow(NotFoundException.class);
        mvc.perform(get("/designs/name").param("inputData", anyString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void getDesignByWrongNameIllegal() throws Exception {
        when(getListOfDesignsByNameServiceJPA.getOneDesignByName(anyString())).thenThrow(IllegalArgumentException.class);
        mvc.perform(get("/designs/name").param("inputData", anyString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(IllegalArgumentException.class, result.getResolvedException()));
    }

    @Test
    public void deleteDesignByWrongIdNPE() throws Exception {
        when(removeDesignServiceJPA.removeDesignById(anyInt())).thenThrow(NullPointerException.class);
        mvc.perform(delete("/designs/{clientId}", anyInt()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isInternalServerError())
                .andExpect(result -> assertInstanceOf(NullPointerException.class, result.getResolvedException()));
    }

    @Test
    public void deleteDesignByWrongIdIdNotFound() throws Exception {
        when(removeDesignServiceJPA.removeDesignById(anyInt())).thenThrow(NotFoundException.class);
        mvc.perform(delete("/designs/{clientId}", anyInt()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(result -> assertInstanceOf(NotFoundException.class, result.getResolvedException()));
    }

    @Test
    public void deleteDesignByWrongNameInvalid() throws Exception {
        when(removeDesignServiceJPA.removeDesignById(anyInt())).thenThrow(InvalidParameterException.class);
        mvc.perform(delete("/designs/{clientId}", anyInt()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertInstanceOf(InvalidParameterException.class, result.getResolvedException()));
    }



}
