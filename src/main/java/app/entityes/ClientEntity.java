package app.entityes;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "public", catalog = "sale_of_apartments")
public class ClientEntity {
    @Expose()
    private Integer idClient;
    @Expose()
    private String name;
    @Expose()
    private String surname;
    @Expose()
    private String patronymic;
    @Expose()
    private Date dateOfBirth;
    @Expose()
    private String phoneNumber;
    @Expose()
    private String email;
    @Expose()
    private Boolean gender;

    @Expose(serialize = false, deserialize = false)
    private Collection<ApartmentEntity> apartmentsByIdClient;
    @Expose(serialize = false, deserialize = false)
    private Collection<ApartmentSaleEntity> apartmentSalesByIdClient;
    @Expose(serialize = false, deserialize = false)
    private Collection<DocumentsClientEntity> documentsClientsByIdClient;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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
    public String getSurname() {return surname;}

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Basic
    @Column(name = "patronymic", nullable = true, length = 50)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "date_of_birth", nullable = false)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "phone_number", nullable = false, length = 10)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 50)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "gender", nullable = true)
    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientEntity that = (ClientEntity) o;
        return idClient == that.idClient &&
                Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(dateOfBirth, that.dateOfBirth) &&
                Objects.equals(phoneNumber, that.phoneNumber) &&
                Objects.equals(email, that.email) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, name, surname, patronymic, dateOfBirth, phoneNumber, email, gender);
    }

    @OneToMany(mappedBy = "clientByApartmentOwner")
    public Collection<ApartmentEntity> getApartmentsByIdClient() {
        return apartmentsByIdClient;
    }

    public void setApartmentsByIdClient(Collection<ApartmentEntity> apartmentsByIdClient) {
        this.apartmentsByIdClient = apartmentsByIdClient;
    }

    @OneToMany(mappedBy = "clientByOwnerApartment")
    public Collection<ApartmentSaleEntity> getApartmentSalesByIdClient() {
        return apartmentSalesByIdClient;
    }

    public void setApartmentSalesByIdClient(Collection<ApartmentSaleEntity> apartmentSalesByIdClient) {
        this.apartmentSalesByIdClient = apartmentSalesByIdClient;
    }

    @OneToMany(mappedBy = "clientByClient")
    public Collection<DocumentsClientEntity> getDocumentsClientsByIdClient() {
        return documentsClientsByIdClient;
    }

    public void setDocumentsClientsByIdClient(Collection<DocumentsClientEntity> documentsClientsByIdClient) {
        this.documentsClientsByIdClient = documentsClientsByIdClient;
    }
}
