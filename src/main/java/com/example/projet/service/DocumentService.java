package com.example.projet.service;

import com.example.projet.model.entity.Document;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.stream.Stream;

public interface DocumentService {

    Document store(MultipartFile file,Long idTYpeDoc) throws IOException;
    Document storeByNiveau(MultipartFile file,Long idTypeDoc, Long idNiveau) throws IOException;
    Document storeBySection(MultipartFile file,Long idTypeDoc, Long idSection) throws IOException;
    Document getDocument(String id);
    Stream<Document> getAllDocuments();
}
