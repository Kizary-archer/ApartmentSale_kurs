package app.entityes;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "name_street", schema = "public", catalog = "sale_of_apartments")
public class NameStreetEntity {
    private Integer idName;
    private String nameStreet;
    private Collection<StreetEntity> streetsByIdName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_name", nullable = false)
    public Integer getIdName() {
        return idName;
    }

    public void setIdName(Integer idName) {
        this.idName = idName;
    }

    @Basic
    @Column(name = "name_street", nullable = false, length = 50)
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

    @OneToMany(mappedBy = "nameStreetByNameStreet")
    public Collection<StreetEntity> getStreetsByIdName() {
        return streetsByIdName;
    }

    public void setStreetsByIdName(Collection<StreetEntity> streetsByIdName) {
        this.streetsByIdName = streetsByIdName;
    }
}
