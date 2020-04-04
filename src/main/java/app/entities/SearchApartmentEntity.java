package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "search_apartment", schema = "public", catalog = "zzz")
public class SearchApartmentEntity {
    private int idApartment;
    private Float countRoom;
    private Integer livingSpace;
    private Object meterPrice;
    private Integer street;
    private Integer district;
    private Integer city;
    private Object price;
    private int client;
    private Collection<ApartmentSaleEntity> apartmentSalesByIdApartment;
    private StreetEntity streetByStreet;
    private DisrictEntity disrictByDistrict;
    private CityEntity cityByCity;
    private ClientEntity clientByClient;

    @Id
    @Column(name = "id_apartment", nullable = false)
    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    @Basic
    @Column(name = "count_room", nullable = true, precision = 0)
    public Float getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(Float countRoom) {
        this.countRoom = countRoom;
    }

    @Basic
    @Column(name = "living_space", nullable = true)
    public Integer getLivingSpace() {
        return livingSpace;
    }

    public void setLivingSpace(Integer livingSpace) {
        this.livingSpace = livingSpace;
    }

    @Basic
    @Column(name = "meter_price", nullable = true)
    public Object getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(Object meterPrice) {
        this.meterPrice = meterPrice;
    }

    @Basic
    @Column(name = "street", nullable = true)
    public Integer getStreet() {
        return street;
    }

    public void setStreet(Integer street) {
        this.street = street;
    }

    @Basic
    @Column(name = "district", nullable = true)
    public Integer getDistrict() {
        return district;
    }

    public void setDistrict(Integer district) {
        this.district = district;
    }

    @Basic
    @Column(name = "city", nullable = true)
    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    @Basic
    @Column(name = "price", nullable = true)
    public Object getPrice() {
        return price;
    }

    public void setPrice(Object price) {
        this.price = price;
    }

    @Basic
    @Column(name = "client", nullable = false)
    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
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
                Objects.equals(meterPrice, that.meterPrice) &&
                Objects.equals(street, that.street) &&
                Objects.equals(district, that.district) &&
                Objects.equals(city, that.city) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idApartment, countRoom, livingSpace, meterPrice, street, district, city, price, client);
    }

    @OneToMany(mappedBy = "searchApartmentBySearchApartment")
    public Collection<ApartmentSaleEntity> getApartmentSalesByIdApartment() {
        return apartmentSalesByIdApartment;
    }

    public void setApartmentSalesByIdApartment(Collection<ApartmentSaleEntity> apartmentSalesByIdApartment) {
        this.apartmentSalesByIdApartment = apartmentSalesByIdApartment;
    }

    @ManyToOne
    @JoinColumn(name = "street", referencedColumnName = "id_street")
    public StreetEntity getStreetByStreet() {
        return streetByStreet;
    }

    public void setStreetByStreet(StreetEntity streetByStreet) {
        this.streetByStreet = streetByStreet;
    }

    @ManyToOne
    @JoinColumn(name = "district", referencedColumnName = "id_district")
    public DisrictEntity getDisrictByDistrict() {
        return disrictByDistrict;
    }

    public void setDisrictByDistrict(DisrictEntity disrictByDistrict) {
        this.disrictByDistrict = disrictByDistrict;
    }

    @ManyToOne
    @JoinColumn(name = "city", referencedColumnName = "id_city")
    public CityEntity getCityByCity() {
        return cityByCity;
    }

    public void setCityByCity(CityEntity cityByCity) {
        this.cityByCity = cityByCity;
    }

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id_client", nullable = false)
    public ClientEntity getClientByClient() {
        return clientByClient;
    }

    public void setClientByClient(ClientEntity clientByClient) {
        this.clientByClient = clientByClient;
    }
}
