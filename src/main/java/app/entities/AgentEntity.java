package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "agent", schema = "public", catalog = "sale_of_apartments")
public class AgentEntity {
    private Integer idAgent;
    private String name;
    private String surname;
    private String patronymic;
    private Integer percent;
    private Integer phoneNumber;
    private Collection<ApartmentSaleEntity> apartmentSalesByIdAgent;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agent", nullable = false)
    public Integer getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(Integer idAgent) {
        this.idAgent = idAgent;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname", nullable = false, length = 50)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "patronymic", nullable = false, length = 50)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "percent", nullable = false)
    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    @Basic
    @Column(name = "phone_number", nullable = false)
    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgentEntity that = (AgentEntity) o;
        return idAgent == that.idAgent &&
                percent == that.percent &&
                phoneNumber == that.phoneNumber &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(patronymic, that.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgent, name, surname, patronymic, percent, phoneNumber);
    }

    @OneToMany(mappedBy = "agentByAgent")
    public Collection<ApartmentSaleEntity> getApartmentSalesByIdAgent() {
        return apartmentSalesByIdAgent;
    }

    public void setApartmentSalesByIdAgent(Collection<ApartmentSaleEntity> apartmentSalesByIdAgent) {
        this.apartmentSalesByIdAgent = apartmentSalesByIdAgent;
    }
}
