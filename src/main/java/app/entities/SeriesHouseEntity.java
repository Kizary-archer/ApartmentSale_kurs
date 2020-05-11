package app.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "series_house", schema = "public", catalog = "sale_of_apartments")
public class SeriesHouseEntity {
    private int idSeries;
    private String nameSeries;
    private String descriotion;
    private Collection<HouseEntity> housesByIdSeries;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_series", nullable = false)
    public int getIdSeries() {
        return idSeries;
    }

    public void setIdSeries(int idSeries) {
        this.idSeries = idSeries;
    }

    @Basic
    @Column(name = "name_series", nullable = false, length = 50)
    public String getNameSeries() {
        return nameSeries;
    }

    public void setNameSeries(String nameSeries) {
        this.nameSeries = nameSeries;
    }

    @Basic
    @Column(name = "descriotion", nullable = true, length = 200)
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

    @OneToMany(mappedBy = "seriesHouseBySeries")
    public Collection<HouseEntity> getHousesByIdSeries() {
        return housesByIdSeries;
    }

    public void setHousesByIdSeries(Collection<HouseEntity> housesByIdSeries) {
        this.housesByIdSeries = housesByIdSeries;
    }
}
