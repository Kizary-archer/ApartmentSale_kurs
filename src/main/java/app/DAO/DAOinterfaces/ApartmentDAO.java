package app.DAO.DAOinterfaces;

import app.entities.ApartmentEntity;
import app.entities.ClientEntity;
import app.entities.HouseEntity;

import java.util.Collection;

public interface ApartmentDAO extends DAOMain<ApartmentEntity> {

    public Collection<HouseEntity> getHouses(int limit, int offset, HouseEntity houseEntity);
    public ApartmentEntity getApartmentAllChild(int idApartment);
    public ApartmentEntity getApartmentById(int idApartment);

}
