package app.DAO.DAOinterfaces;

import app.entities.ApartmentSaleEntity;
import app.entities.ClientEntity;

import java.util.Collection;

public interface ApartmentSaleDAO extends DAOMain<ApartmentSaleEntity> {

    public Collection<ApartmentSaleEntity> getApartmentSales(int limit, int offset, ApartmentSaleEntity apartmentSaleEntity);
    public ApartmentSaleEntity getApartmentSaleById(int idApartment);
}
