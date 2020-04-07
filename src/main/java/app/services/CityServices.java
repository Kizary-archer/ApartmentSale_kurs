package app.services;

import app.entities.CityEntity;
import app.DAO.CityDAOImpl;

import java.sql.SQLException;

public class CityServices {
    private CityDAOImpl cityDAO = new CityDAOImpl();

    public boolean AddCity(CityEntity city) throws SQLException {
        cityDAO.AddCity(city);
      return true;
    }
}
