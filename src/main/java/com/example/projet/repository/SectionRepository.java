package com.example.projet.repository;


import com.example.projet.model.entity.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectionRepository extends CrudRepository<Section,Long> {
    List<Section> findBySpecialiteIdSpec(Long id);
    List<Section> findByNiveauIdNiveau(Long id);
}
