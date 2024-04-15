package org.nailproject.repository;

import org.nailproject.entity.nail.NailDesign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NailDesignRepositoryJPA extends JpaRepository<NailDesign, Integer> {
    List<NailDesign> getNailDesignSByName(String name);
    List<NailDesign> getNailDesignByClient_Id(Integer id);
}
