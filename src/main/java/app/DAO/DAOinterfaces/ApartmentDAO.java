package app.DAO.DAOinterfaces;

import app.entities.ApartmentEntity;
import app.entities.ClientEntity;
import app.entities.HouseEntity;
import app.entities.houseView;

import java.util.Collection;

public interface ApartmentDAO extends DAOMain<ApartmentEntity> {

    public Collection<houseView> getHousesView(int limit, int offset, houseView houseView);
    public ApartmentEntity getApartmentAllChild(int idApartment);
    public ApartmentEntity getApartmentById(int idApartment);

}
