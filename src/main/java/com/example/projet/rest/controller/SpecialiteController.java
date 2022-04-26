package com.example.projet.rest.controller;



import com.example.projet.model.entity.Specialite;
import com.example.projet.rest.dto.SpecialiteDto;
import com.example.projet.service.SpecialiteService;
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
public class SpecialiteController {
    @Autowired
    private SpecialiteService specialiteService ;
    @Autowired
    private ModelMapper modelMapper ;


    @GetMapping("/Specialites")
    public Object Specialitelist() {
        List<Specialite> spec= specialiteService.getSpecialiteList();
        Type listType = new TypeToken<List<SpecialiteDto>>() {}.getType() ;
        List <SpecialiteDto> specialiteDtos= modelMapper.map(spec,listType);
        return ResponseEntity.status(HttpStatus.OK).body(specialiteDtos);
    }
    @GetMapping("/Specialites/{idspecialite}")
    public Object Specialite(@PathVariable Long idspecialite ) {
        Specialite e = specialiteService.getSpecialite(idspecialite) ;
        SpecialiteDto dto= modelMapper.map(e, SpecialiteDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/Specialites")
    public Object AddSpecialite(@Validated @RequestBody SpecialiteDto dto)
    {
        Specialite specialite = modelMapper.map(dto, Specialite.class);
        specialite = specialiteService.AddSpecialite(specialite);
        dto = modelMapper.map(specialite, SpecialiteDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/Specialites/{idspecialite}")
    public Object UpdateSpecialite (@Validated @RequestBody SpecialiteDto dto , @PathVariable Long idspecialite) {
        Specialite specialite = modelMapper.map(dto,Specialite.class);
        specialite= specialiteService.UpdateSpecialite(idspecialite, specialite);
        dto = modelMapper.map(specialite,SpecialiteDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @DeleteMapping("/Specialite/{idspecialite}")
    public Object DeleteSpecialite(@PathVariable Long idspecialite) {
        specialiteService.DeleteSpecialite(idspecialite);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
