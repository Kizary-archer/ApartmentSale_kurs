package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "street", schema = "public", catalog = "sale_of_apartments")
public class StreetEntity {
    private int idStreet;
    private int nameStreet;
    private int district;

    @Id
    @Column(name = "id_street")
    public int getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(int idStreet) {
        this.idStreet = idStreet;
    }

    @Basic
    @Column(name = "name_street")
    public int getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(int nameStreet) {
        this.nameStreet = nameStreet;
    }

    @Basic
    @Column(name = "district")
    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreetEntity that = (StreetEntity) o;
        return idStreet == that.idStreet &&
                nameStreet == that.nameStreet &&
                district == that.district;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStreet, nameStreet, district);
    }
}
