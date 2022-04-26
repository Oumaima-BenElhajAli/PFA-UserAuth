package com.example.projet.service;

import com.example.projet.model.entity.Specialite;
import com.example.projet.model.entity.TypeDoc;

import java.util.List;

public interface TypeDocService {
    TypeDoc getTypeDoc(Long id);
    List<TypeDoc> getTypeDocList();
    TypeDoc AddTypeDoc(TypeDoc typeDoc);
    TypeDoc UpdateTypeDoc(Long id,TypeDoc typeDoc);
    void DeleteTypeDoc(Long id);
}
