package com.example.projet.repository;

import com.example.projet.model.entity.Specialite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialiteRepository extends CrudRepository<Specialite,Long> {
}