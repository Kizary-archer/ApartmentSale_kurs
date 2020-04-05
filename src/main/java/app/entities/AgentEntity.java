package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "agent", schema = "public", catalog = "sale_of_apartments")
public class AgentEntity {
    private int idAgent;
    private String name;
    private String surname;
    private String patronymic;
    private int percent;
    private int phoneNumber;

    @Id
    @Column(name = "id_agent")
    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "percent")
    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }

    @Basic
    @Column(name = "phone_number")
    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
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
}
