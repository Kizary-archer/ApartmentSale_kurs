package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "street", schema = "public", catalog = "zzz")
public class StreetEntity {
    private int idStreet;
    private String nameStreet;
    private int district;
    private Collection<HouseEntity> housesByIdStreet;
    private Collection<SearchApartmentEntity> searchApartmentsByIdStreet;
    private DisrictEntity disrictByDistrict;

    @Id
    @Column(name = "id_street", nullable = false)
    public int getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(int idStreet) {
        this.idStreet = idStreet;
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
    @Column(name = "district", nullable = false)
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
                district == that.district &&
                Objects.equals(nameStreet, that.nameStreet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStreet, nameStreet, district);
    }

    @OneToMany(mappedBy = "streetByStreet")
    public Collection<HouseEntity> getHousesByIdStreet() {
        return housesByIdStreet;
    }

    public void setHousesByIdStreet(Collection<HouseEntity> housesByIdStreet) {
        this.housesByIdStreet = housesByIdStreet;
    }

    @OneToMany(mappedBy = "streetByStreet")
    public Collection<SearchApartmentEntity> getSearchApartmentsByIdStreet() {
        return searchApartmentsByIdStreet;
    }

    public void setSearchApartmentsByIdStreet(Collection<SearchApartmentEntity> searchApartmentsByIdStreet) {
        this.searchApartmentsByIdStreet = searchApartmentsByIdStreet;
    }

    @ManyToOne
    @JoinColumn(name = "district", referencedColumnName = "id_district", nullable = false)
    public DisrictEntity getDisrictByDistrict() {
        return disrictByDistrict;
    }

    public void setDisrictByDistrict(DisrictEntity disrictByDistrict) {
        this.disrictByDistrict = disrictByDistrict;
    }
}
