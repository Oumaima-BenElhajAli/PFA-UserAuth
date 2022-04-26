package com.example.projet.service;


import com.example.projet.model.entity.Specialite;

import java.util.List;

public interface SpecialiteService {

    Specialite getSpecialite(Long id);
    List<Specialite> getSpecialiteList();
    Specialite AddSpecialite(Specialite e);
    Specialite UpdateSpecialite(Long id,Specialite e);
    void DeleteSpecialite(Long id);
}
