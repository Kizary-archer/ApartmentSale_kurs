package app.DAO.DAOinterfaces;

import app.entities.CityEntity;

import java.sql.SQLException;
import java.util.Collection;

public interface CityDAO extends DAOMain
{

    public boolean addCity(CityEntity city) throws SQLException;
    public Collection getDistrictByCity(CityEntity city) throws SQLException;
    public CityEntity getCity(String id) throws SQLException;
    public boolean deleteCity(CityEntity city) throws SQLException;
    public boolean updateCity(CityEntity city) throws SQLException;

}
