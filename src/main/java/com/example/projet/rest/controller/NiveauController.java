package com.example.projet.rest.controller;


import com.example.projet.model.entity.Niveau;
import com.example.projet.rest.dto.NiveauDto;
import com.example.projet.service.NiveauService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.List;

@RestController
@CrossOrigin
public class NiveauController {
    @Autowired
    private NiveauService niveauService ;
    @Autowired
    private ModelMapper modelMapper ;

    @GetMapping("/Niveaux")
    public Object Niveaulist() {
        List<Niveau> mat= niveauService.getNiveauList();
        Type listType = new TypeToken<List<NiveauDto>>() {}.getType() ;
        List <NiveauDto> niveauDtos= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(niveauDtos);
    }
    @GetMapping("/NiveauxPr")
    public Object NiveaulistPr() {
        List<Niveau> mat= niveauService.getNiveauListPri();
        Type listType = new TypeToken<List<NiveauDto>>() {}.getType() ;
        List <NiveauDto> niveauDtos= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(niveauDtos);
    }

    @GetMapping("/NiveauxSec")
    public Object NiveaulistSec() {
        List<Niveau> mat= niveauService.getNiveauListSec();
        Type listType = new TypeToken<List<NiveauDto>>() {}.getType() ;
        List <NiveauDto> niveauDtos= modelMapper.map(mat,listType);
        return ResponseEntity.status(HttpStatus.OK).body(niveauDtos);
    }
    @GetMapping("/Niveaux/{idniveau}")
    public Object Niveau(@PathVariable Long idniveau ) {
        Niveau e = niveauService.getNiveau(idniveau) ;
        NiveauDto dto= modelMapper.map(e, NiveauDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/Niveaux")
    public Object AddNiveau(@Validated @RequestBody NiveauDto dto)
    {
        Niveau niv = modelMapper.map(dto, Niveau.class);
        niv = niveauService.AddNiveau(niv);
        dto = modelMapper.map(niv, NiveauDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/Niveaux/{idniveau}")
    public Object UpdateNiveau (@Validated @RequestBody NiveauDto dto , @PathVariable Long idniveau) {
        Niveau niveau = modelMapper.map(dto,Niveau.class);
        niveau= niveauService.UpdateNiveau(idniveau, niveau);
        dto = modelMapper.map(niveau,NiveauDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @DeleteMapping("/Niveaux/{idniveau}")
    public Object DeleteNiveau(@PathVariable Long idniveau) {
        niveauService.DeleteNiveau(idniveau);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
