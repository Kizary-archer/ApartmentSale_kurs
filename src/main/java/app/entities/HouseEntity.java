package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "house", schema = "public", catalog = "sale_of_apartments")
public class HouseEntity {
    private int idHouse;
    private String numberHouse;
    private int street;
    private Integer series;

    @Id
    @Column(name = "id_house")
    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
        this.idHouse = idHouse;
    }

    @Basic
    @Column(name = "number_house")
    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    @Basic
    @Column(name = "street")
    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    @Basic
    @Column(name = "series")
    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseEntity that = (HouseEntity) o;
        return idHouse == that.idHouse &&
                street == that.street &&
                Objects.equals(numberHouse, that.numberHouse) &&
                Objects.equals(series, that.series);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idHouse, numberHouse, street, series);
    }
}
