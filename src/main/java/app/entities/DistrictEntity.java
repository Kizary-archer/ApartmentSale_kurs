package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "district", schema = "public", catalog = "sale_of_apartments")
public class DistrictEntity {
    private int idDistrict;
    private String nameDistrict;
    private int city;

    @Id
    @Column(name = "id_district")
    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
    }

    @Basic
    @Column(name = "name_district")
    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    @Basic
    @Column(name = "city")
    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DistrictEntity that = (DistrictEntity) o;
        return idDistrict == that.idDistrict &&
                city == that.city &&
                Objects.equals(nameDistrict, that.nameDistrict);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistrict, nameDistrict, city);
    }
}
