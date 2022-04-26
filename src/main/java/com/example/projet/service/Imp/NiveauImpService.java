package com.example.projet.service.Imp;

import com.example.projet.model.entity.Niveau;
import com.example.projet.repository.NiveauRepository;

import com.example.projet.service.NiveauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NiveauImpService implements NiveauService {
    @Autowired
    private NiveauRepository nivRepository ;

    @Override
    public Niveau getNiveau(Long id) {
        return nivRepository.findById(id).get();
    }

    @Override
    public List<Niveau> getNiveauList() {
        return (List<Niveau>)nivRepository.findAll();
    }

    @Override
    public List<Niveau> getNiveauListPri() {
        return (List<Niveau>)nivRepository.findByPrimSec(0);
    }

    @Override
    public List<Niveau> getNiveauListSec() {
        return (List<Niveau>)nivRepository.findByPrimSec(1);
    }

    @Override
    public Niveau AddNiveau(Niveau e) {
        return nivRepository.save(e);
    }

    @Override
    public Niveau UpdateNiveau(Long id, Niveau e) {
        getNiveau(id);
        e.setIdNiveau(id);
        return nivRepository.save(e);
    }


    @Override
    public void DeleteNiveau(Long id) {
        nivRepository.deleteById(id);
    }
}
