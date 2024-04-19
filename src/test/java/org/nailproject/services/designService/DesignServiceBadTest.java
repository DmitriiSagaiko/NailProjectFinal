package org.nailproject.services.designService;

import exceptions.NotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.nailproject.dto.design.DesignRequestDTO;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.nailproject.services.clientServiceJPA.FindClientByIdServiceJPA;
import org.nailproject.services.designServiceJPA.AddDesignServiceJPA;
import org.nailproject.services.designServiceJPA.GetAllDesignServiceByClientIdJPA;
import org.nailproject.services.designServiceJPA.GetListOfDesignsByNameServiceJPA;
import org.nailproject.services.designServiceJPA.RemoveDesignServiceJPA;
import org.springframework.boot.test.context.SpringBootTest;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class DesignServiceBadTest {
    @Mock
    FindClientByIdServiceJPA findClientByIdServiceJPA;

    @Mock
    NailDesignRepositoryJPA repository;
    @Mock
    NailDesign nailDesign = new NailDesign();

    @Mock
    DesignRequestDTO dto = new DesignRequestDTO();

    @InjectMocks
    AddDesignServiceJPA addDesignService;
    @InjectMocks
    GetAllDesignServiceByClientIdJPA getAllDesignService;
    @InjectMocks
    GetListOfDesignsByNameServiceJPA getListOfDesignsByNameServiceJPA;
    @InjectMocks
    RemoveDesignServiceJPA removeDesignServiceJPA;

    int testId = 5;

    @Test
    public void testAddBadDesign(){
        when(findClientByIdServiceJPA.findOptionalClientById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, ()-> addDesignService.addNailDesign(dto));
    }

    @Test
    public void testGetAllBadDesignByClientId(){
        when(getAllDesignService.getAllDesignsById(testId)).thenReturn(Collections.emptyList());
        assertTrue(getAllDesignService.getAllDesignsById(testId).isEmpty());
    }

    @Test
    public void testGetBadDesignByDesignName(){
        assertThrows(IllegalArgumentException.class, ()-> getListOfDesignsByNameServiceJPA.getOneDesignByName(null));
        assertThrows(IllegalArgumentException.class, ()-> getListOfDesignsByNameServiceJPA.getOneDesignByName(""));
        when(repository.getNailDesignSByName(anyString())).thenReturn(Collections.emptyList());
        assertThrows(NotFoundException.class, ()-> getListOfDesignsByNameServiceJPA.getOneDesignByName("test"));
    }

    @Test
    public void testRemoveBadDesign(){
        assertThrows(InvalidParameterException.class, ()-> removeDesignServiceJPA.removeDesignById(null));
        assertThrows(InvalidParameterException.class, ()-> removeDesignServiceJPA.removeDesignById(0));
        assertThrows(InvalidParameterException.class, ()-> removeDesignServiceJPA.removeDesignById(-1));

        when(repository.findById(anyInt())).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, ()-> removeDesignServiceJPA.removeDesignById(testId));
    }
}
