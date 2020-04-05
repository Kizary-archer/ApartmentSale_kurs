package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "client_role", schema = "public", catalog = "sale_of_apartments")
public class ClientRoleEntity {
    private int idRole;
    private String nameStatus;

    @Id
    @Column(name = "id_role")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Basic
    @Column(name = "name_status")
    public String getNameStatus() {
        return nameStatus;
    }

    public void setNameStatus(String nameStatus) {
        this.nameStatus = nameStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientRoleEntity that = (ClientRoleEntity) o;
        return idRole == that.idRole &&
                Objects.equals(nameStatus, that.nameStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, nameStatus);
    }
}
