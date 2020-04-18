package app.DAO;

import app.DAO.DAOinterfaces.CityDAO;
import app.entities.CityEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

public class CityDAOImpl implements CityDAO {


    @Override
    public boolean addCity(CityEntity city)throws SQLException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
           System.out.println(e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Collection getDistrictByCity(CityEntity city) throws SQLException {
        return null;
    }

    @Override
    public CityEntity getCity(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean deleteCity(CityEntity city) throws SQLException {
        return false;
    }

    @Override
    public boolean updateCity(CityEntity city) throws SQLException {
        return false;
    }
}
