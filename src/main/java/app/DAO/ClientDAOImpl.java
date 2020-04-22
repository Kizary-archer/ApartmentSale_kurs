package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.entities.ClientEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.Collection;

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
    public Collection<ClientEntity> getAllClient() {
        return null;
    }

    @Override
    public Collection<ClientEntity> getClientDocument(ClientEntity clientEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c from ClientEntity c left join fetch c.documentsClientsByIdClient where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",clientEntity.getIdClient());
            session.getTransaction().commit();
            return (Collection<ClientEntity>) query.getResultList();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
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
            return (ClientEntity) query.getSingleResult();
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
