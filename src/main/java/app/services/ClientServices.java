package app.services;

import app.DAO.DAOinterfaces.CityDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entities.CityEntity;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public class ClientServices {

   /* public boolean addClient(String name,
                             String surname,
                             String patronymic,
                             Date dateOfBirth,
                             String phoneNumber,
                             String email,
                             Boolean gender) throws SQLException {
        if(cityName =="")return false;
        CityDAO cityDAO = DAOCreateFactoryUtil.getInstance().getCityDAO();
      return cityDAO.addCity(new CityEntity(cityName));
    }

    public Collection getDistrictByCity(CityEntity city) throws SQLException {
        CityDAO cityDAO = DAOCreateFactoryUtil.getInstance().getCityDAO();
        cityDAO.getDistrictByCity(city);
        return null;
    }*/
}
