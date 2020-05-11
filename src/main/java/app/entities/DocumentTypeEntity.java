package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "document_type", schema = "public", catalog = "sale_of_apartments")
public class DocumentTypeEntity {
    private int idType;
    private String nameType;
    private Collection<DocumentsClientEntity> documentsClientsByIdType;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type", nullable = false)
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "name_type", nullable = false, length = 50)
    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocumentTypeEntity that = (DocumentTypeEntity) o;
        return idType == that.idType &&
                Objects.equals(nameType, that.nameType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idType, nameType);
    }

    @OneToMany(mappedBy = "documentTypeByTypeDocument")
    public Collection<DocumentsClientEntity> getDocumentsClientsByIdType() {
        return documentsClientsByIdType;
    }

    public void setDocumentsClientsByIdType(Collection<DocumentsClientEntity> documentsClientsByIdType) {
        this.documentsClientsByIdType = documentsClientsByIdType;
    }
}
