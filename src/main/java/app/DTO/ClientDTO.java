package app.DTO;

import app.entities.ApartmentEntity;
import app.entities.ApartmentSaleEntity;
import app.entities.DocumentsClientEntity;
import app.entities.SearchApartmentEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

public class ClientDTO implements Serializable {
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

    public ClientDTO(){}
    public ClientDTO(String name,
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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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
        ClientDTO that = (ClientDTO) o;
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

    public Collection<ApartmentEntity> getApartmentsByIdClient() {
        return apartmentsByIdClient;
    }

    public void setApartmentsByIdClient(Collection<ApartmentEntity> apartmentsByIdClient) {
        this.apartmentsByIdClient = apartmentsByIdClient;
    }

    public Collection<ApartmentSaleEntity> getApartmentSalesByIdClient() {
        return apartmentSalesByIdClient;
    }

    public void setApartmentSalesByIdClient(Collection<ApartmentSaleEntity> apartmentSalesByIdClient) {
        this.apartmentSalesByIdClient = apartmentSalesByIdClient;
    }

    public Collection<DocumentsClientEntity> getDocumentsClientsByIdClient() {
        return documentsClientsByIdClient;
    }

    public void setDocumentsClientsByIdClient(Collection<DocumentsClientEntity> documentsClientsByIdClient) {
        this.documentsClientsByIdClient = documentsClientsByIdClient;
    }

    public Collection<SearchApartmentEntity> getSearchApartmentsByIdClient() {
        return searchApartmentsByIdClient;
    }

    public void setSearchApartmentsByIdClient(Collection<SearchApartmentEntity> searchApartmentsByIdClient) {
        this.searchApartmentsByIdClient = searchApartmentsByIdClient;
    }
}
