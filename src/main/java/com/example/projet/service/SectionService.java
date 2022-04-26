package com.example.projet.service;

import com.example.projet.model.entity.Section;

import java.util.List;

public interface SectionService {
    Section getSection(Long id);
    List<Section> getSectionList(Long id);
    Section AddSection(Section e);
    Section UpdateSection(Long id,Section e);
    void DeleteSection(Long id);

}
