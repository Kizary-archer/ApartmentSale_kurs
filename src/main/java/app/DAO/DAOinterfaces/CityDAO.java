package app.DAO.DAOinterfaces;

import app.entities.CityEntity;

import java.sql.SQLException;

public interface CityDAO extends DAOcrud {

    public boolean AddCity(CityEntity city) throws SQLException;
}
