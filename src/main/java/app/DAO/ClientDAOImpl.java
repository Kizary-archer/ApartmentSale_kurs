package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.entities.ClientEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public boolean addClient(ClientEntity client) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public Collection<String> getAllClient() {
        return null;
    }

    @Override
    public Collection<String> getClientDocument(ClientEntity clientEntity) {
        return null;
    }

    @Override
    public ClientEntity getClientById(int id) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from ClientEntity where idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",id);
            session.getTransaction().commit();
           ClientEntity clientEntity = (ClientEntity) query.getSingleResult();
            return clientEntity;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
