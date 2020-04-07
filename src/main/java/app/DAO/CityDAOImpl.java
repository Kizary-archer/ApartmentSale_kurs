package app.DAO;

import app.DAO.DAOinterfaces.CityDAO;
import app.entities.CityEntity;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.Collection;

public class CityDAOImpl implements CityDAO {
    @Override
    public boolean AddCity(CityEntity city)throws SQLException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.save(city);
            session.getTransaction().commit();
        } catch (Exception e) {
           System.out.println(e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean Create(String query) {
        return false;
    }

    @Override
    public Collection Select(String query) {
        return null;
    }

    @Override
    public boolean Update(String query) {
        return false;
    }

    @Override
    public boolean Delete(String query) {
        return false;
    }
}
