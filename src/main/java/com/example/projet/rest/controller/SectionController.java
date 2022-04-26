package com.example.projet.rest.controller;


import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.Section;
import com.example.projet.model.entity.Specialite;
import com.example.projet.rest.dto.SectionDto;
import com.example.projet.service.NiveauService;
import com.example.projet.service.SectionService;
import com.example.projet.service.SpecialiteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private SpecialiteService specialiteService;
    @Autowired
    private NiveauService niveauService;

    @GetMapping("/Niveaux/{idNiv}/Sections")

    public Object SectionList(@PathVariable Long idNiv) {
        List<Section> sectionList = sectionService.getSectionList(idNiv);
        Type listType = new TypeToken<List<SectionDto>>() {}.getType();
        List<SectionDto> sectionDtos = modelMapper.map(sectionList,listType);
        return ResponseEntity.status(HttpStatus.OK).body(sectionDtos);
    }



    @GetMapping("/Sections/{idsec}")
    public Object retrieveSection(@PathVariable Long idsec) {
        Section s = sectionService.getSection(idsec);
        SectionDto sectionDto = modelMapper.map(s,SectionDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(sectionDto);
    }


    @PostMapping("/Niveaux/{idniv}/Specialites/{idSpec}/Sections")
    public Object addSection(@PathVariable Long idniv,@PathVariable Long idSpec,@Validated @RequestBody SectionDto sectionDto) {
        Section section = modelMapper.map(sectionDto,Section.class);
        Niveau niveau = niveauService.getNiveau(idniv);
        Specialite specialite = specialiteService.getSpecialite(idSpec);
        section.setNiveau(niveau);
        section.setSpecialite(specialite);
        section.setLibelle(niveau.getLibelle()+" — "+specialite.getLibelle());
        section = sectionService.AddSection(section);
        sectionDto = modelMapper.map(section, SectionDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(sectionDto);
    }

    @DeleteMapping("/Sections/{idsec}")
    public Object Delete(@PathVariable Long idsec) {
        sectionService.DeleteSection(idsec);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }


}
