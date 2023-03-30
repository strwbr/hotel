package com.example.hotel.services.impl;

import com.example.hotel.model.DocumentType;
import com.example.hotel.repos.DocumentTypeRepository;
import com.example.hotel.services.DocumentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return null;
    }

    @Override
    public void deleteDocumentTypeById(long id) {
        this.repository.deleteById(id);
    }
}
