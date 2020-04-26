package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.entities.ClientEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Collection;
import java.util.Date;

public class ClientDAOImpl implements ClientDAO {

    @Override
    public Collection<ClientEntity> getAllClient() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct c from ClientEntity c ";
            Query query =  session.createQuery(hql);
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
    public Collection<ClientEntity> getClients(int limit, int offset, ClientEntity clientEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<ClientEntity> cr = cb.createQuery(ClientEntity.class);
            Root<ClientEntity> root = cr.from(ClientEntity.class);
            cr.select(root);
            cr.where(cb.like(root.get("name"),"Philippa"),cb.like(root.get("surname"),"Jayne"));

            Query query = session.createQuery(cr);
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
    public ClientEntity getClientDocument(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.documentsClientsByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
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

    @Override
    public ClientEntity getClientapartmentSales(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.apartmentSalesByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
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

    @Override
    public ClientEntity getClientapartments(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.apartmentsByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
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

    @Override
    public ClientEntity getClientsearchApartments(int idClient) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from ClientEntity c " +
                    "left join fetch c.searchApartmentsByIdClient " +
                    "where c.idClient = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idClient);
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
