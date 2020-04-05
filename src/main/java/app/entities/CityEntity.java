package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "public", catalog = "sale_of_apartments")
public class CityEntity {
    private int idCity;
    private String nameCity;

    @Id
    @Column(name = "id_city")
    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Basic
    @Column(name = "name_city")
    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityEntity that = (CityEntity) o;
        return idCity == that.idCity &&
                Objects.equals(nameCity, that.nameCity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, nameCity);
    }
}
