package app.DAO.DAOinterfaces;

import app.DAO.DAOinterfaces.DAOMain;
import app.entities.ClientEntity;
import app.entities.SearchApartmentEntity;

import java.util.Collection;

public interface SearchApartmentDAO extends DAOMain<SearchApartmentEntity> {

    public Collection<SearchApartmentEntity> getAllSearchApartment();
    public Collection<SearchApartmentEntity> getSearchApartments(int limit, int offset, SearchApartmentEntity searchApartmentEntity);

    public SearchApartmentEntity getApartmentSales(int idApart);
    public SearchApartmentEntity getSearchApartmentById(int idApart);
}
