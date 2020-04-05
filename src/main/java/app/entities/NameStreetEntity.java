package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "name_street", schema = "public", catalog = "sale_of_apartments")
public class NameStreetEntity {
    private int idName;
    private String nameStreet;

    @Id
    @Column(name = "id_name")
    public int getIdName() {
        return idName;
    }

    public void setIdName(int idName) {
        this.idName = idName;
    }

    @Basic
    @Column(name = "name_street")
    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NameStreetEntity that = (NameStreetEntity) o;
        return idName == that.idName &&
                Objects.equals(nameStreet, that.nameStreet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idName, nameStreet);
    }
}
