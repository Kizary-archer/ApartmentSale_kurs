package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "series_house", schema = "public", catalog = "sale_of_apartments")
public class SeriesHouseEntity {
    private int idSeries;
    private String nameSeries;
    private String descriotion;

    @Id
    @Column(name = "id_series")
    public int getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(int idSeries) {
        this.idSeries = idSeries;
    }

    @Basic
    @Column(name = "name_series")
    public String getNameSeries() {
        return nameSeries;
    }

    public void setNameSeries(String nameSeries) {
        this.nameSeries = nameSeries;
    }

    @Basic
    @Column(name = "descriotion")
    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeriesHouseEntity that = (SeriesHouseEntity) o;
        return idSeries == that.idSeries &&
                Objects.equals(nameSeries, that.nameSeries) &&
                Objects.equals(descriotion, that.descriotion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSeries, nameSeries, descriotion);
    }
}
