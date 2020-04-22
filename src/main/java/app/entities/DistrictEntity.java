package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "district", schema = "public", catalog = "sale_of_apartments")
public class DistrictEntity {
    private int idDistrict;
    private String nameDistrict;
    private int city;
    private CityEntity cityByCity;
    private Collection<SearchApartmentEntity> searchApartmentsByIdDistrict;
    private Collection<StreetEntity> streetsByIdDistrict;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_district", nullable = false)
    public int getIdDistrict() {
        return idDistrict;
    }

    public void setIdDistrict(int idDistrict) {
        this.idDistrict = idDistrict;
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
    @Column(name = "city", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city", referencedColumnName = "id_city", nullable = false,insertable = false, updatable = false)
    public CityEntity getCityByCity() {
        return cityByCity;
    }

    public void setCityByCity(CityEntity cityByCity) {
        this.cityByCity = cityByCity;
    }

    @OneToMany(mappedBy = "districtByDistrict")
    public Collection<SearchApartmentEntity> getSearchApartmentsByIdDistrict() {
        return searchApartmentsByIdDistrict;
    }

    public void setSearchApartmentsByIdDistrict(Collection<SearchApartmentEntity> searchApartmentsByIdDistrict) {
        this.searchApartmentsByIdDistrict = searchApartmentsByIdDistrict;
    }

    @OneToMany(mappedBy = "districtByDistrict")
    public Collection<StreetEntity> getStreetsByIdDistrict() {
        return streetsByIdDistrict;
    }

    public void setStreetsByIdDistrict(Collection<StreetEntity> streetsByIdDistrict) {
        this.streetsByIdDistrict = streetsByIdDistrict;
    }
}
