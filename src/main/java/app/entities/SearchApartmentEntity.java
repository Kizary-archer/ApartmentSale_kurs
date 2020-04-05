package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "search_apartment", schema = "public", catalog = "sale_of_apartments")
public class SearchApartmentEntity {
    private int idApartment;
    private Float countRoom;
    private Integer livingSpace;
    private Integer street;
    private Integer district;
    private Integer city;
    private int client;
    private Integer meterPrice;
    private Integer price;

    @Id
    @Column(name = "id_apartment")
    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    @Basic
    @Column(name = "count_room")
    public Float getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(Float countRoom) {
        this.countRoom = countRoom;
    }

    @Basic
    @Column(name = "living_space")
    public Integer getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(Integer livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Basic
    @Column(name = "street")
    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    @Basic
    @Column(name = "district")
    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city")
    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Basic
    @Column(name = "client")
    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    @Basic
    @Column(name = "meter_price")
    public Integer getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(Integer meterPrice) {
        this.meterPrice = meterPrice;
    }

    @Basic
    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchApartmentEntity that = (SearchApartmentEntity) o;
        return idApartment == that.idApartment &&
                client == that.client &&
                Objects.equals(countRoom, that.countRoom) &&
                Objects.equals(livingSpace, that.livingSpace) &&
                Objects.equals(street, that.street) &&
                Objects.equals(district, that.district) &&
                Objects.equals(city, that.city) &&
                Objects.equals(meterPrice, that.meterPrice) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartment, countRoom, livingSpace, street, district, city, client, meterPrice, price);
    }
}
