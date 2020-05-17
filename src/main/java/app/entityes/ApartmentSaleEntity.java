package app.entityes;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "apartment_sale", schema = "public", catalog = "sale_of_apartments")
public class ApartmentSaleEntity {
    private Integer idSale;
    private Integer apartment;
    private Integer ownerApartment;
    private Integer buyer;
    private Integer agent;
    private Date date;
    private Integer price;
    private ApartmentEntity apartmentByApartment;
    private ClientEntity clientByOwnerApartment;
    private ClientEntity clientByBuyer;
    private AgentEntity agentByAgent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sale", nullable = false)
    public Integer getIdSale() {
        return idSale;
    }

    public void setIdSale(Integer idSale) {
        this.idSale = idSale;
    }

    @Basic
    @Column(name = "apartment", nullable = false)
    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    @Basic
    @Column(name = "owner_apartment", nullable = false)
    public Integer getOwnerApartment() {
        return ownerApartment;
    }

    public void setOwnerApartment(Integer ownerApartment) {
        this.ownerApartment = ownerApartment;
    }

    @Basic
    @Column(name = "buyer", nullable = false)
    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    @Basic
    @Column(name = "agent", nullable = false)
    public Integer getAgent() {
        return agent;
    }

    public void setAgent(Integer agent) {
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
    @Column(name = "price", nullable = false)
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
        ApartmentSaleEntity that = (ApartmentSaleEntity) o;
        return idSale == that.idSale &&
                apartment == that.apartment &&
                ownerApartment == that.ownerApartment &&
                buyer == that.buyer &&
                agent == that.agent &&
                price == that.price &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSale, apartment, ownerApartment, buyer, agent, date,  price);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment", referencedColumnName = "id_apartment", nullable = false,insertable = false, updatable = false)
    public ApartmentEntity getApartmentByApartment() {
        return apartmentByApartment;
    }

    public void setApartmentByApartment(ApartmentEntity apartmentByApartment) {
        this.apartmentByApartment = apartmentByApartment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_apartment", referencedColumnName = "id_client", nullable = false,insertable = false, updatable = false)
    public ClientEntity getClientByOwnerApartment() {
        return clientByOwnerApartment;
    }

    public void setClientByOwnerApartment(ClientEntity clientByOwnerApartment) {
        this.clientByOwnerApartment = clientByOwnerApartment;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer", referencedColumnName = "id_client", nullable = false,insertable = false, updatable = false)
    public ClientEntity getClientByBuyer() {
        return clientByBuyer;
    }

    public void setClientByBuyer(ClientEntity clientByBuyer) {
        this.clientByBuyer = clientByBuyer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent", referencedColumnName = "id_agent", nullable = false,insertable = false, updatable = false)
    public AgentEntity getAgentByAgent() {
        return agentByAgent;
    }

    public void setAgentByAgent(AgentEntity agentByAgent) {
        this.agentByAgent = agentByAgent;
    }

}
