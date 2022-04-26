package com.example.projet.service;

import com.example.projet.model.entity.Niveau;

import java.util.List;

public interface NiveauService {

    Niveau getNiveau(Long id);
    List<Niveau> getNiveauList();
    List<Niveau> getNiveauListPri();
    List<Niveau> getNiveauListSec();
    Niveau AddNiveau(Niveau e);
    Niveau UpdateNiveau(Long id,Niveau e);
    void DeleteNiveau(Long id);
}
