package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "house", schema = "public", catalog = "sale_of_apartments")
public class HouseEntity {
    private int idHouse;
    private String numberHouse;
    private int street;
    private Integer series;
    private Collection<ApartmentEntity> apartmentsByIdHouse;
    private StreetEntity streetByStreet;
    private SeriesHouseEntity seriesHouseBySeries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_house", nullable = false)
    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
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
    @Column(name = "street", nullable = false)
    public int getStreet() {
        return street;
    }

    public void setStreet(int street) {
        this.street = street;
    }

    @Basic
    @Column(name = "series", nullable = true)
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

    @OneToMany(mappedBy = "houseByHouse")
    public Collection<ApartmentEntity> getApartmentsByIdHouse() {
        return apartmentsByIdHouse;
    }

    public void setApartmentsByIdHouse(Collection<ApartmentEntity> apartmentsByIdHouse) {
        this.apartmentsByIdHouse = apartmentsByIdHouse;
    }

    @ManyToOne
    @JoinColumn(name = "street", referencedColumnName = "id_street", nullable = false,insertable = false, updatable = false)
    public StreetEntity getStreetByStreet() {
        return streetByStreet;
    }

    public void setStreetByStreet(StreetEntity streetByStreet) {
        this.streetByStreet = streetByStreet;
    }

    @ManyToOne
    @JoinColumn(name = "series", referencedColumnName = "id_series",insertable = false, updatable = false)
    public SeriesHouseEntity getSeriesHouseBySeries() {
        return seriesHouseBySeries;
    }

    public void setSeriesHouseBySeries(SeriesHouseEntity seriesHouseBySeries) {
        this.seriesHouseBySeries = seriesHouseBySeries;
    }
}
