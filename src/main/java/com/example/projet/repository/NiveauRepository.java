package com.example.projet.repository;
import com.example.projet.model.entity.Niveau;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NiveauRepository extends CrudRepository<Niveau,Long> {
    List<Niveau>findByPrimSec(int i);
}
