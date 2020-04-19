package app.DAO.DAOinterfaces;

import app.Util.HibernateSessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface DAOMain {

    public default Session getSession() throws HibernateException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}
