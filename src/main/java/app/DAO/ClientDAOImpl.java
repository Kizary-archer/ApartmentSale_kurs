package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.entities.ClientEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<ClientEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(ClientEntity.class);
            Root<ClientEntity> root = criteriaBuilderQuery.from(ClientEntity.class);
            criteriaBuilderQuery.select(root);
          /*  cr.where(
                    cb.or(
                    cb.like(root.get("name"),"Philippa"),
                    cb.like(root.get("surname"),"Jayne")
                    )
            );*/
            List<Predicate> p = new ArrayList<Predicate>();

            if(clientEntity.getName() != null){
                p.add(criteriaBuilder.like(root.get("name"),clientEntity.getName()));
            }
            if(clientEntity.getSurname() != null){
                p.add(criteriaBuilder.like(root.get("surname"),clientEntity.getSurname()));
            }
            if(clientEntity.getPatronymic() != null){
                p.add(criteriaBuilder.like(root.get("patronymic"),clientEntity.getPatronymic()));
            }
            if(clientEntity.getDateOfBirth() != null){
                p.add(criteriaBuilder.like(root.get("DateOfBirth"),clientEntity.getDateOfBirth().toString()));
            }
            if(clientEntity.getEmail() != null){
                p.add(criteriaBuilder.like(root.get("Email"),clientEntity.getEmail()));
            }
            if(clientEntity.getGender() != null){
                p.add(criteriaBuilder.like(root.get("gender"),clientEntity.getGender().toString()));
            }
            if(clientEntity.getPhoneNumber() != null){
                p.add(criteriaBuilder.like(root.get("PhoneNumber"),clientEntity.getPhoneNumber()));
            }
            if(!p.isEmpty()) {
                Predicate[] pr = new Predicate[p.size()];
                p.toArray(pr);
                criteriaBuilderQuery.where((pr));
            }
            Query query = session.createQuery(criteriaBuilderQuery);
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
