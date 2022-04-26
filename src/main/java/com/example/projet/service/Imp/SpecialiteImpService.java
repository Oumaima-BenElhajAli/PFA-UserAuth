package com.example.projet.service.Imp;

import com.example.projet.model.entity.Specialite;
import com.example.projet.repository.SpecialiteRepository;
import com.example.projet.service.SpecialiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialiteImpService implements SpecialiteService {
    @Autowired
    private SpecialiteRepository specialiteRepository ;

    @Override
    public Specialite getSpecialite(Long id) {
        return specialiteRepository.findById(id).get();
    }

    @Override
    public List<Specialite> getSpecialiteList() {
        return (List<Specialite>)specialiteRepository.findAll();
    }

    @Override
    public Specialite AddSpecialite(Specialite e) {
        return specialiteRepository.save(e);
    }

    @Override
    public Specialite UpdateSpecialite(Long id, Specialite e) {
        getSpecialite(id);
        e.setIdSpec(id);
        return specialiteRepository.save(e);
    }


    @Override
    public void DeleteSpecialite(Long id) {
        specialiteRepository.deleteById(id);
    }
}
