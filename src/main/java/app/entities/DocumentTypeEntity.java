package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "document_type", schema = "public", catalog = "sale_of_apartments")
public class DocumentTypeEntity {
    private int idType;
    private String nameType;

    @Id
    @Column(name = "id_type")
    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Basic
    @Column(name = "name_type")
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
}
