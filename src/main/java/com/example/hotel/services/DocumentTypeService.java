package com.example.hotel.services;

import com.example.hotel.model.DocumentType;

import java.util.List;

public interface DocumentTypeService {
    List<DocumentType> getAllDocumentTypes();
    void saveDocumentType(DocumentType documentType);
    DocumentType getDocumentTypeById(long id);
    void deleteDocumentTypeById(long id);
}
