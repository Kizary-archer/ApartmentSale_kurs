package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "street", schema = "public", catalog = "sale_of_apartments")
public class StreetEntity {
    private int idStreet;
    private int nameStreet;
    private int district;
    private Collection<HouseEntity> housesByIdStreet;
    private NameStreetEntity nameStreetByNameStreet;
    private DistrictEntity districtByDistrict;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_street", nullable = false)
    public int getIdStreet() {
        return idStreet;
    }

    public void setIdStreet(int idStreet) {
        this.idStreet = idStreet;
    }

    @Basic
    @Column(name = "name_street", nullable = false)
    public int getNameStreet() {
        return nameStreet;
    }

    public void setNameStreet(int nameStreet) {
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
                nameStreet == that.nameStreet &&
                district == that.district;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name_street", referencedColumnName = "id_name", nullable = false,insertable = false, updatable = false)
    public NameStreetEntity getNameStreetByNameStreet() {
        return nameStreetByNameStreet;
    }

    public void setNameStreetByNameStreet(NameStreetEntity nameStreetByNameStreet) {
        this.nameStreetByNameStreet = nameStreetByNameStreet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district", referencedColumnName = "id_district", nullable = false,insertable = false, updatable = false)
    public DistrictEntity getDistrictByDistrict() {
        return districtByDistrict;
    }

    public void setDistrictByDistrict(DistrictEntity districtByDistrict) {
        this.districtByDistrict = districtByDistrict;
    }
}
