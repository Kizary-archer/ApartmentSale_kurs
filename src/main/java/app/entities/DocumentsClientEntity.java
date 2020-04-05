package app.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "documents_client", schema = "public", catalog = "sale_of_apartments")
public class DocumentsClientEntity {
    private int idPassport;
    private int series;
    private int number;
    private String issued;
    private Date dateOfIssue;
    private int typeDocument;
    private int client;

    @Id
    @Column(name = "id_passport")
    public int getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(int idPassport) {
        this.idPassport = idPassport;
    }

    @Basic
    @Column(name = "series")
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "issued")
    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    @Basic
    @Column(name = "date_of_issue")
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Basic
    @Column(name = "type_document")
    public int getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(int typeDocument) {
        this.typeDocument = typeDocument;
    }

    @Basic
    @Column(name = "client")
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
        DocumentsClientEntity that = (DocumentsClientEntity) o;
        return idPassport == that.idPassport &&
                series == that.series &&
                number == that.number &&
                typeDocument == that.typeDocument &&
                client == that.client &&
                Objects.equals(issued, that.issued) &&
                Objects.equals(dateOfIssue, that.dateOfIssue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPassport, series, number, issued, dateOfIssue, typeDocument, client);
    }
}
