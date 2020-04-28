package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "search_apartment", schema = "public", catalog = "sale_of_apartments")
public class SearchApartmentEntity {
    private int idApartment;
    private Integer countRoom;
    private Integer livingSpace;
    private Integer street;
    private Integer district;
    private Integer city;
    private Integer client;
    private Integer meterPrice;
    private Integer price;
    private Collection<ApartmentSaleEntity> apartmentSalesByIdApartment;
    private StreetEntity streetByStreet;
    private DistrictEntity districtByDistrict;
    private CityEntity cityByCity;
    private ClientEntity clientByClient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_apartment", nullable = false)
    public int getIdApartment() {
        return idApartment;
    }

    public void setIdApartment(int idApartment) {
        this.idApartment = idApartment;
    }

    @Basic
    @Column(name = "count_room", nullable = true, precision = 0)
    public Integer getCountRoom() {
        return countRoom;
    }

    public void setCountRoom(Integer countRoom) {
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
    @Column(name = "client", nullable = false)
    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    @Basic
    @Column(name = "meter_price", nullable = true)
    public Integer getMeterPrice() {
        return meterPrice;
    }

    public void setMeterPrice(Integer meterPrice) {
        this.meterPrice = meterPrice;
    }

    @Basic
    @Column(name = "price", nullable = true)
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

    @OneToMany(mappedBy = "searchApartmentBySearchApartment")
    public Collection<ApartmentSaleEntity> getApartmentSalesByIdApartment() {
        return apartmentSalesByIdApartment;
    }

    public void setApartmentSalesByIdApartment(Collection<ApartmentSaleEntity> apartmentSalesByIdApartment) {
        this.apartmentSalesByIdApartment = apartmentSalesByIdApartment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street", referencedColumnName = "id_street",insertable = false, updatable = false)
    public StreetEntity getStreetByStreet() {
        return streetByStreet;
    }

    public void setStreetByStreet(StreetEntity streetByStreet) {
        this.streetByStreet = streetByStreet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district", referencedColumnName = "id_district",insertable = false, updatable = false)
    public DistrictEntity getDistrictByDistrict() {
        return districtByDistrict;
    }

    public void setDistrictByDistrict(DistrictEntity districtByDistrict) {
        this.districtByDistrict = districtByDistrict;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city", referencedColumnName = "id_city",insertable = false, updatable = false)
    public CityEntity getCityByCity() {
        return cityByCity;
    }

    public void setCityByCity(CityEntity cityByCity) {
        this.cityByCity = cityByCity;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client", referencedColumnName = "id_client", nullable = false,insertable = false, updatable = false)
    public ClientEntity getClientByClient() {
        return clientByClient;
    }

    public void setClientByClient(ClientEntity clientByClient) {
        this.clientByClient = clientByClient;
    }
}
