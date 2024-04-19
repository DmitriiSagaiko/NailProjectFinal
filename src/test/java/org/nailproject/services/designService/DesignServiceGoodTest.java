package org.nailproject.services.designService;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.nailproject.entity.nail.NailDesign;
import org.nailproject.repository.NailDesignRepositoryJPA;
import org.nailproject.services.designServiceJPA.AddDesignServiceJPA;
import org.nailproject.services.designServiceJPA.GetAllDesignServiceByClientIdJPA;
import org.nailproject.services.designServiceJPA.GetListOfDesignsByNameServiceJPA;
import org.nailproject.services.designServiceJPA.RemoveDesignServiceJPA;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class DesignServiceGoodTest {
    @Mock
    NailDesignRepositoryJPA repository;
    @Mock
    NailDesign nailDesign = new NailDesign();

    @InjectMocks
    AddDesignServiceJPA addDesignService;
    @InjectMocks
    GetAllDesignServiceByClientIdJPA getAllDesignService;
    @InjectMocks
    GetListOfDesignsByNameServiceJPA getListOfDesignsByNameServiceJPA;
    @InjectMocks
    RemoveDesignServiceJPA removeDesignServiceJPA;


    @Test
    public void testAddDesignService() {
        when(repository.save(any(NailDesign.class))).thenReturn(new NailDesign());
        repository.save(nailDesign);
        verify(repository, times(1)).save(any(NailDesign.class));
    }

    @Test
    public void testGetAllDesignService() {
        when(repository.getNailDesignByClient_Id(anyInt())).thenReturn(new ArrayList<>());
        repository.getNailDesignByClient_Id(5);
        verify(repository, times(1)).getNailDesignByClient_Id(5);
    }

    @Test
    public void testGetListOfDesignsByName() {
        when(repository.getNailDesignSByName(anyString())).thenReturn(new ArrayList<>());
        repository.getNailDesignSByName("Test Name");
        verify(repository, times(1)).getNailDesignSByName(anyString());
    }

    @Test
    public void testRemoveDesignService() {
        when(repository.findById(anyInt())).thenReturn(Optional.of(nailDesign));
        repository.deleteById(5);
        verify(repository, times(1)).deleteById(anyInt());
    }

}