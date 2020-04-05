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
    private DocumentTypeEntity documentTypeByTypeDocument;
    private ClientEntity clientByClient;

    @Id
    @Column(name = "id_passport", nullable = false)
    public int getIdPassport() {
        return idPassport;
    }

    public void setIdPassport(int idPassport) {
        this.idPassport = idPassport;
    }

    @Basic
    @Column(name = "series", nullable = false)
    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Basic
    @Column(name = "number", nullable = false)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Basic
    @Column(name = "issued", nullable = false, length = 200)
    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    @Basic
    @Column(name = "date_of_issue", nullable = false)
    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Basic
    @Column(name = "type_document", nullable = false)
    public int getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(int typeDocument) {
        this.typeDocument = typeDocument;
    }

    @Basic
    @Column(name = "client", nullable = false)
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

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_document", referencedColumnName = "id_type", nullable = false,insertable=false, updatable=false)
    public DocumentTypeEntity getDocumentTypeByTypeDocument() {
        return documentTypeByTypeDocument;
    }

    public void setDocumentTypeByTypeDocument(DocumentTypeEntity documentTypeByTypeDocument) {
        this.documentTypeByTypeDocument = documentTypeByTypeDocument;
    }

    @ManyToOne(optional = false)
    @JoinColumn(name = "client", referencedColumnName = "id_client", nullable = false,insertable=false, updatable=false)
    public ClientEntity getClientByClient() {
        return clientByClient;
    }

    public void setClientByClient(ClientEntity clientByClient) {
        this.clientByClient = clientByClient;
    }
}
