package com.example.hotel.services.impl;

import com.example.hotel.model.Departure;
import com.example.hotel.model.DocumentType;
import com.example.hotel.repos.DocumentTypeRepository;
import com.example.hotel.services.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

    @Autowired
    private DocumentTypeRepository repository;

    @Override
    public List<DocumentType> getAllDocumentTypes() {
        return this.repository.findAll();
    }

    @Override
    public void saveDocumentType(DocumentType documentType) {
        this.repository.save(documentType);
    }

    @Override
    public DocumentType getDocumentTypeById(long id) {
        Optional<DocumentType> optional = repository.findById(id);
        DocumentType documentType = null;
        if (optional.isPresent())
            documentType = optional.get();
        else throw new RuntimeException("DocumentType NOT found for id : \" + id");
        return documentType;
    }

    @Override
    public void deleteDocumentTypeById(long id) {
        this.repository.deleteById(id);
    }
}
