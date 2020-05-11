package app.DAO.DAOinterfaces;

import app.entities.ApartmentEntity;
import app.entities.HouseView;

import java.util.Collection;
import java.util.List;

public interface ApartmentDAO extends DAOMain<ApartmentEntity> {

    public Collection<HouseView> getHousesView(int limit, int offset, HouseView houseView);
    public Collection<ApartmentEntity> getApartmentsList(int limit, int offset, ApartmentEntity apartmentEntity);
    public ApartmentEntity getApartmentAllChild(int idApartment);
    public ApartmentEntity getApartmentById(int idApartment);

}
