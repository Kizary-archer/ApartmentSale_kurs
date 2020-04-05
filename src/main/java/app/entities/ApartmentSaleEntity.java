package app.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "apartment_sale", schema = "public", catalog = "sale_of_apartments")
public class ApartmentSaleEntity {
    private int idSale;
    private int apartment;
    private int ownerApartment;
    private int buyer;
    private int agent;
    private Date date;
    private Integer searchApartment;
    private int price;

    @Id
    @Column(name = "id_sale")
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "apartment")
    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Basic
    @Column(name = "owner_apartment")
    public int getOwnerApartment() {
        return ownerApartment;
    }

    public void setOwnerApartment(int ownerApartment) {
        this.ownerApartment = ownerApartment;
    }

    @Basic
    @Column(name = "buyer")
    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    @Basic
    @Column(name = "agent")
    public int getAgent() {
        return agent;
    }

    public void setAgent(int agent) {
        this.agent = agent;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "search_apartment")
    public Integer getSearchApartment() {
        return searchApartment;
    }

    public void setSearchApartment(Integer searchApartment) {
        this.searchApartment = searchApartment;
    }

    @Basic
    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentSaleEntity that = (ApartmentSaleEntity) o;
        return idSale == that.idSale &&
                apartment == that.apartment &&
                ownerApartment == that.ownerApartment &&
                buyer == that.buyer &&
                agent == that.agent &&
                price == that.price &&
                Objects.equals(date, that.date) &&
                Objects.equals(searchApartment, that.searchApartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, apartment, ownerApartment, buyer, agent, date, searchApartment, price);
    }
}
