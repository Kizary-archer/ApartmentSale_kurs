package app.DAO.DAOinterfaces;

import app.Util.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Collection;

public interface DAOcrud {

    public default Session getSession() throws HibernateException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
    public boolean Create(String query);
    public Collection Select(String query);
    public boolean Update(String query);
    public boolean Delete(String query);
}
