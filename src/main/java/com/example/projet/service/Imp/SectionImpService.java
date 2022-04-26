package com.example.projet.service.Imp;

import com.example.projet.model.entity.Section;
import com.example.projet.repository.SectionRepository;
import com.example.projet.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SectionImpService implements SectionService {
    @Autowired
    private SectionRepository sectionRepository ;

    @Override
    public Section getSection(Long id) {
        return sectionRepository.findById(id).get();
    }

    @Override
    public List<Section> getSectionList(Long id) {
        return (List<Section>)sectionRepository.findByNiveauIdNiveau(id);
    }

    @Override
    public Section AddSection(Section e) {
        return sectionRepository.save(e);
    }

    @Override
    public Section UpdateSection(Long id, Section e) {
        getSection(id);
        e.setIdSection(id);
        return sectionRepository.save(e);
    }


    @Override
    public void DeleteSection(Long id) {
        sectionRepository.deleteById(id);
    }
}
