package app.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "client", schema = "public", catalog = "sale_of_apartments")
public class ClientEntity {
    private int idClient;
    private String name;
    private String surname;
    private String patronymic;
    private Date dateOfBirth;
    private String phoneNumber;
    private String email;
    private Boolean gender;
    private Collection<ApartmentEntity> apartmentsByIdClient;
    private Collection<ApartmentSaleEntity> apartmentSalesByIdClient;
    private Collection<DocumentsClientEntity> documentsClientsByIdClient;
    private Collection<SearchApartmentEntity> searchApartmentsByIdClient;

    public ClientEntity(){}
    public ClientEntity(String name,
                        String surname,
                        String patronymic,
                        Date dateOfBirth,
                        String phoneNumber,
                        String email,
                        Boolean gender){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.gender = gender;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
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
    public String getSurname() {
        int a = 1;
        return surname;
    }

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

    @OneToMany(mappedBy = "clientByClient")
    public Collection<SearchApartmentEntity> getSearchApartmentsByIdClient() {
        return searchApartmentsByIdClient;
    }

    public void setSearchApartmentsByIdClient(Collection<SearchApartmentEntity> searchApartmentsByIdClient) {
        this.searchApartmentsByIdClient = searchApartmentsByIdClient;
    }
}
