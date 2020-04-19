package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.entities.ClientEntity;
import org.hibernate.Session;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public boolean addUser(ClientEntity client) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.save(client);
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
}
