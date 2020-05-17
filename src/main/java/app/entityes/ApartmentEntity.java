package app.entityes;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "apartment", schema = "public", catalog = "sale_of_apartments")
public class ApartmentEntity {
    @Expose()//gson
    private Integer idApartment;
    @Expose()
    private Integer numberApartment;
    @Expose()
    private Integer countRoom;
    @Expose()
    private Float livingSpace;
    @Expose()
    private Integer house;
    @Expose()
    private Integer apartmentOwner;
    @Expose()
    private Integer meterPrice;

    @Expose(serialize = false, deserialize = false)
    private HouseEntity houseByHouse;
    @Expose (serialize = false, deserialize = false)
    private ClientEntity clientByApartmentOwner;
    @Expose (serialize = false, deserialize = false)
    private Collection<ApartmentSaleEntity> apartmentSalesByIdApartment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment", nullable = false)
    public Integer getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(Integer idApartment) {
        this.idApartment = idApartment;
    }

    @Basic
    @Column(name = "number_apartment", nullable = false)
    public Integer getNumberApartment() {
        return numberApartment;
    }

    public void setNumberApartment(Integer numberApartment) {
        this.numberApartment = numberApartment;
    }

    @Basic
    @Column(name = "count_room", nullable = false)
    public Integer getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(Integer countRoom) {
        this.countRoom = countRoom;
    }

    @Basic
    @Column(name = "living_space", nullable = false, precision = 0)
    public Float getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(Float livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Basic
    @Column(name = "house", nullable = false)
    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    @Basic
    @Column(name = "apartment_owner", nullable = false)
    public Integer getApartmentOwner() {
        return apartmentOwner;
    }

    public void setApartmentOwner(Integer apartmentOwner) {
        this.apartmentOwner = apartmentOwner;
    }

    @Basic
    @Column(name = "meter_price", nullable = false)
    public Integer getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(Integer meterPrice) {
        this.meterPrice = meterPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentEntity that = (ApartmentEntity) o;
        return idApartment == that.idApartment &&
                numberApartment == that.numberApartment &&
                countRoom == that.countRoom &&
                Float.compare(that.livingSpace, livingSpace) == 0 &&
                house == that.house &&
                apartmentOwner == that.apartmentOwner &&
                meterPrice == that.meterPrice;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartment, numberApartment, countRoom, livingSpace, house, apartmentOwner, meterPrice);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "house", referencedColumnName = "id_house", nullable = false,insertable = false, updatable = false)
    public HouseEntity getHouseByHouse() {
        return houseByHouse;
    }

    public void setHouseByHouse(HouseEntity houseByHouse) {
        this.houseByHouse = houseByHouse;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_owner", referencedColumnName = "id_client", nullable = false,insertable = false, updatable = false)
    public ClientEntity getClientByApartmentOwner() {
        return clientByApartmentOwner;
    }

    public void setClientByApartmentOwner(ClientEntity clientByApartmentOwner) {
        this.clientByApartmentOwner = clientByApartmentOwner;
    }

    @OneToMany(mappedBy = "apartmentByApartment")
    public Collection<ApartmentSaleEntity> getApartmentSalesByIdApartment() {
        return apartmentSalesByIdApartment;
    }

    public void setApartmentSalesByIdApartment(Collection<ApartmentSaleEntity> apartmentSalesByIdApartment) {
        this.apartmentSalesByIdApartment = apartmentSalesByIdApartment;
    }
}
