package com.example.projet.rest.controller;

import com.example.projet.message.ResponseFile;
import com.example.projet.message.ResponseMessage;
import com.example.projet.model.entity.Document;
import com.example.projet.rest.dto.DocumentDto;
import com.example.projet.service.DocumentService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@CrossOrigin
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @PostMapping("/typedoc/{idTypeDoc}/document")
    public ResponseEntity<ResponseMessage> UploadDocument(@PathVariable Long idTypeDoc,@RequestParam("document") MultipartFile file) {
        String message = "";
        try {
            documentService.store(file,idTypeDoc);
            message = "Téléversé le fichier avec succès: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible d'importer le fichier: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/niveaux/{idNiveau}/typedoc/{idTypeDoc}/document")
    public ResponseEntity<ResponseMessage> UploadDocumentByNiveau(@PathVariable Long idNiveau,@PathVariable Long idTypeDoc,@RequestParam("document") MultipartFile file) {
        String message = "";
        try {
            documentService.storeByNiveau(file,idTypeDoc,idNiveau);
            message = "Téléversé le fichier avec succès: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible d'importer le fichier: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @PostMapping("/sections/{idSection}/typedoc/{idTypeDoc}/document")
    public ResponseEntity<ResponseMessage> UploadDocumentBySection(@PathVariable Long idSection,@PathVariable Long idTypeDoc,@RequestParam("document") MultipartFile file) {
        String message = "";
        try {
            documentService.storeBySection(file,idTypeDoc,idSection);
            message = "Téléversé le fichier avec succès: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Impossible d'importer le fichier: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping("/documents")
    public ResponseEntity<List<ResponseFile>> getListDocuments() {
        List<ResponseFile> files = documentService.getAllDocuments().map(document -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/documents/")
                    .path(document.getId())
                    .toUriString();
            return new ResponseFile(
                    document.getNom(),
                    fileDownloadUri,
                    document.getType(),
                    document.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    @GetMapping("/documents/{id}")
    public ResponseEntity<byte[]> getDocument(@PathVariable String id) {
        Document document = documentService.getDocument(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + document.getNom() + "\"")
                .body(document.getData());
    }

}
