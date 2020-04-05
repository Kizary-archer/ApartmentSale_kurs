package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "apartment", schema = "public", catalog = "sale_of_apartments")
public class ApartmentEntity {
    private int idApartment;
    private int numberApartment;
    private int countRoom;
    private float livingSpace;
    private int house;
    private int apartmentOwner;
    private int meterPrice;

    @Id
    @Column(name = "id_apartment")
    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    @Basic
    @Column(name = "number_apartment")
    public int getNumberApartment() {
        return numberApartment;
    }

    public void setNumberApartment(int numberApartment) {
        this.numberApartment = numberApartment;
    }

    @Basic
    @Column(name = "count_room")
    public int getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(int countRoom) {
        this.countRoom = countRoom;
    }

    @Basic
    @Column(name = "living_space")
    public float getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(float livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Basic
    @Column(name = "house")
    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    @Basic
    @Column(name = "apartment_owner")
    public int getApartmentOwner() {
        return apartmentOwner;
    }

    public void setApartmentOwner(int apartmentOwner) {
        this.apartmentOwner = apartmentOwner;
    }

    @Basic
    @Column(name = "meter_price")
    public int getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(int meterPrice) {
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
}
