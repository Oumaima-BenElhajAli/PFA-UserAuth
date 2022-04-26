package com.example.projet.rest.controller;

import com.example.projet.model.entity.TypeDoc;
import com.example.projet.rest.dto.TypeDocDto;
import com.example.projet.service.TypeDocService;
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
public class TypeDocController {
    @Autowired
    private TypeDocService typeDocService ;
    @Autowired
    private ModelMapper modelMapper ;


    @GetMapping("/TypeDocs")
    public Object TypeDoclist() {
        List<TypeDoc> type= typeDocService.getTypeDocList();
        Type listType = new TypeToken<List<TypeDocDto>>() {}.getType() ;
        List <TypeDocDto> typeDocDtos= modelMapper.map(type,listType);
        return ResponseEntity.status(HttpStatus.OK).body(typeDocDtos);
    }
    @GetMapping("/TypeDocs/{idTypeDoc}")
    public Object TypeDoc(@PathVariable Long idTypeDoc ) {
        TypeDoc e = typeDocService.getTypeDoc(idTypeDoc) ;
        TypeDocDto dto= modelMapper.map(e, TypeDocDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping("/TypeDocs")
    public Object AddTypeDoc(@Validated @RequestBody TypeDocDto dto)
    {
        TypeDoc typeDoc = modelMapper.map(dto, TypeDoc.class);
        typeDoc = typeDocService.AddTypeDoc(typeDoc);
        dto = modelMapper.map(typeDoc, TypeDocDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/TypeDocs/{idTypeDoc}")
    public Object UpdateTypeDoc (@Validated @RequestBody TypeDocDto dto , @PathVariable Long idTypeDoc) {
        TypeDoc typeDoc = modelMapper.map(dto,TypeDoc.class);
        typeDoc= typeDocService.UpdateTypeDoc(idTypeDoc, typeDoc);
        dto = modelMapper.map(typeDoc,TypeDocDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);

    }

    @DeleteMapping("/TypeDoc/{idTypeDoc}")
    public Object DeleteTypeDoc(@PathVariable Long idTypeDoc) {
        typeDocService.DeleteTypeDoc(idTypeDoc);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
