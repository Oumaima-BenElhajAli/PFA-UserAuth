package com.example.projet.service.Imp;

import com.example.projet.model.entity.TypeDoc;
import com.example.projet.repository.TypeDocRepository;
import com.example.projet.service.TypeDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TypeDocImpService implements TypeDocService {
    @Autowired
    private TypeDocRepository typeDocRepository ;

    @Override
    public TypeDoc getTypeDoc(Long id) { return typeDocRepository.findById(id).get(); }

    @Override
    public List<TypeDoc> getTypeDocList() { return (List<TypeDoc>)typeDocRepository.findAll(); }

    @Override
    public TypeDoc AddTypeDoc(TypeDoc typeDoc) {
        return typeDocRepository.save(typeDoc);
    }

    @Override
    public TypeDoc UpdateTypeDoc(Long id, TypeDoc typeDoc) {
        getTypeDoc(id);
        typeDoc.setIdTypeDoc(id);
        return typeDocRepository.save(typeDoc);
    }

    @Override
    public void DeleteTypeDoc(Long id) {
        typeDocRepository.deleteById(id);
    }
}
