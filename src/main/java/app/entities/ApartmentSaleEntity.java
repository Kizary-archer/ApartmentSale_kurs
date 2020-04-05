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
    private ApartmentEntity apartmentByApartment;
    private ClientEntity clientByOwnerApartment;
    private ClientEntity clientByBuyer;
    private AgentEntity agentByAgent;
    private SearchApartmentEntity searchApartmentBySearchApartment;

    @Id
    @Column(name = "id_sale", nullable = false)
    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "apartment", nullable = false)
    public int getApartment() {
        return apartment;
    }

    public void setApartment(int apartment) {
        this.apartment = apartment;
    }

    @Basic
    @Column(name = "owner_apartment", nullable = false)
    public int getOwnerApartment() {
        return ownerApartment;
    }

    public void setOwnerApartment(int ownerApartment) {
        this.ownerApartment = ownerApartment;
    }

    @Basic
    @Column(name = "buyer", nullable = false)
    public int getBuyer() {
        return buyer;
    }

    public void setBuyer(int buyer) {
        this.buyer = buyer;
    }

    @Basic
    @Column(name = "agent", nullable = false)
    public int getAgent() {
        return agent;
    }

    public void setAgent(int agent) {
        this.agent = agent;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "search_apartment", nullable = true)
    public Integer getSearchApartment() {
        return searchApartment;
    }

    public void setSearchApartment(Integer searchApartment) {
        this.searchApartment = searchApartment;
    }

    @Basic
    @Column(name = "price", nullable = false)
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

    @ManyToOne(optional=false)
    @JoinColumn(name = "apartment", referencedColumnName = "id_apartment", nullable = false,insertable=false, updatable=false)
    public ApartmentEntity getApartmentByApartment() {
        return apartmentByApartment;
    }

    public void setApartmentByApartment(ApartmentEntity apartmentByApartment) {
        this.apartmentByApartment = apartmentByApartment;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name = "owner_apartment", referencedColumnName = "id_client", nullable = false,insertable=false, updatable=false)
    public ClientEntity getClientByOwnerApartment() {
        return clientByOwnerApartment;
    }

    public void setClientByOwnerApartment(ClientEntity clientByOwnerApartment) {
        this.clientByOwnerApartment = clientByOwnerApartment;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name = "buyer", referencedColumnName = "id_client", nullable = false,insertable=false, updatable=false)
    public ClientEntity getClientByBuyer() {
        return clientByBuyer;
    }

    public void setClientByBuyer(ClientEntity clientByBuyer) {
        this.clientByBuyer = clientByBuyer;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name = "agent", referencedColumnName = "id_agent", nullable = false,insertable=false, updatable=false)
    public AgentEntity getAgentByAgent() {
        return agentByAgent;
    }

    public void setAgentByAgent(AgentEntity agentByAgent) {
        this.agentByAgent = agentByAgent;
    }

    @ManyToOne(optional=false)
    @JoinColumn(name = "search_apartment", referencedColumnName = "id_apartment",insertable=false, updatable=false)
    public SearchApartmentEntity getSearchApartmentBySearchApartment() {
        return searchApartmentBySearchApartment;
    }

    public void setSearchApartmentBySearchApartment(SearchApartmentEntity searchApartmentBySearchApartment) {
        this.searchApartmentBySearchApartment = searchApartmentBySearchApartment;
    }
}
