package app.entities;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Immutable
@Table(name = "houseview")
public class houseView {

    private Integer idHouse;
    private String numberHouse;
    private String nameSeries;
    private String nameStreet;
    private String nameDistrict;
    private String nameCity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_house", nullable = false)
    public Integer getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(Integer idHouse) {
        this.idHouse = idHouse;
    }

    @Basic
    @Column(name = "number_house", nullable = false, length = 10)
    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    @Basic
    @Column(name = "name_series", nullable = false, length = 50)
    public String getNameSeries() {
        return nameSeries;
    }

    public void setNameSeries(String nameSeries) {
        this.nameSeries = nameSeries;
    }

    @Basic
    @Column(name = "name_street", nullable = false, length = 50)
    public String getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(String nameStreet) {
        this.nameStreet = nameStreet;
    }

    @Basic
    @Column(name = "name_district", nullable = false, length = 50)
    public String getNameDistrict() {
        return nameDistrict;
    }

    public void setNameDistrict(String nameDistrict) {
        this.nameDistrict = nameDistrict;
    }

    @Basic
    @Column(name = "name_city", nullable = false, length = 50)
    public String getNameCity() {
        return nameCity;
    }

    public void setNameCity(String nameCity) {
        this.nameCity = nameCity;
    }
}
