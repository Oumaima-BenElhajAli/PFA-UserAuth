package com.example.projet.service.Imp;

import com.example.projet.model.entity.Document;
import com.example.projet.model.entity.Niveau;
import com.example.projet.model.entity.Section;
import com.example.projet.model.entity.TypeDoc;
import com.example.projet.repository.DocumentRepository;
import com.example.projet.service.DocumentService;
import com.example.projet.service.NiveauService;
import com.example.projet.service.SectionService;
import com.example.projet.service.TypeDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.stream.Stream;

@Service
public class DocumentImpService implements DocumentService {
    @Autowired
    private DocumentRepository documentRepository ;
    @Autowired
    private TypeDocService typeDocService;
    @Autowired
    private NiveauService niveauService;
    @Autowired
    private SectionService sectionService;

    @Override
    public Document store(MultipartFile file,Long idTYpeDoc) throws IOException {
        TypeDoc typeDoc= typeDocService.getTypeDoc(idTYpeDoc);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes(), new Date(),(file.getSize()*0.00000095367432));
        document.setTypeDoc(typeDoc);
        return documentRepository.save(document);
    }
    @Override
    public Document storeByNiveau(MultipartFile file,Long idTypeDoc, Long idNiveau) throws IOException {
        Niveau niveau= niveauService.getNiveau(idNiveau);
        TypeDoc typeDoc= typeDocService.getTypeDoc(idTypeDoc);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes(), new Date(),(file.getSize()*0.00000095367432));
        document.setTypeDoc(typeDoc);
        document.setNiveau(niveau);
        return documentRepository.save(document);
    }
    @Override
    public Document storeBySection(MultipartFile file,Long idTypeDoc, Long idSection) throws IOException {
        Section section= sectionService.getSection(idSection);
        TypeDoc typeDoc= typeDocService.getTypeDoc(idTypeDoc);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document document = new Document(fileName, file.getContentType(), file.getBytes(), new Date(),(file.getSize()*0.00000095367432));
        document.setTypeDoc(typeDoc);
        document.setSection(section);
        return documentRepository.save(document);
    }
    @Override
    public Document getDocument(String id) {
        return documentRepository.findById(id).get();
    }
    @Override
    public Stream<Document> getAllDocuments() {
        return documentRepository.findAll().stream();
    }
}
