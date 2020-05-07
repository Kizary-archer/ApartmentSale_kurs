package app.DAO.DAOinterfaces;

import app.entities.ClientEntity;
import app.entities.DocumentTypeEntity;
import app.entities.DocumentsClientEntity;

import java.util.Collection;

public interface DocumentDAO extends DAOMain<DocumentsClientEntity> {

    public DocumentsClientEntity getDocumentById(int idDocument);
    public Collection<DocumentTypeEntity> getAllDocumentType(int limit, int offset);
}
