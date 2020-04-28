package app.DAO;

import app.DAO.DAOinterfaces.SearchApartmentDAO;
import app.entities.SearchApartmentEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchApartmentDAOImpl implements SearchApartmentDAO {
    @Override
    public List<SearchApartmentEntity> getAllSearchApartment() {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct c from SearchApartmentEntity c ";
            Query query =  session.createQuery(hql);
            List res = query.getResultList();
            session.getTransaction().commit();
            return res;
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
    public Collection<SearchApartmentEntity> getSearchApartments(int limit, int offset, SearchApartmentEntity searchApartmentEntity) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<SearchApartmentEntity> criteriaBuilderQuery = criteriaBuilder.createQuery(SearchApartmentEntity.class);
            Root<SearchApartmentEntity> root = criteriaBuilderQuery.from(SearchApartmentEntity.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(searchApartmentEntity.getCountRoom() != null){
                p.add(criteriaBuilder.equal(root.get("countRoom"),searchApartmentEntity.getCountRoom()));
            }
            if(searchApartmentEntity.getLivingSpace() != null){
                p.add(criteriaBuilder.equal(root.get("livingSpace"),searchApartmentEntity.getLivingSpace()));
            }
            if(searchApartmentEntity.getMeterPrice() != null){
                p.add(criteriaBuilder.equal(root.get("meterPrice"),searchApartmentEntity.getMeterPrice()));
            }
            if(searchApartmentEntity.getPrice() != null){
                p.add(criteriaBuilder.equal(root.get("price"),searchApartmentEntity.getPrice()));
            }
            if(searchApartmentEntity.getStreet() != null){
                p.add(criteriaBuilder.equal(root.get("street"),searchApartmentEntity.getStreet()));
            }
            if(searchApartmentEntity.getDistrict() != null){
                p.add(criteriaBuilder.equal(root.get("district"),searchApartmentEntity.getDistrict()));
            }
            if(searchApartmentEntity.getCity() != null){
                p.add(criteriaBuilder.equal(root.get("city"),searchApartmentEntity.getCity()));
            }
            if(searchApartmentEntity.getClient() != null){
                p.add(criteriaBuilder.equal(root.get("client"),searchApartmentEntity.getClient()));
            }
            if(!p.isEmpty()) {
                Predicate[] pr = new Predicate[p.size()];
                p.toArray(pr);
                criteriaBuilderQuery.where((pr));
            }
            Query query = session.createQuery(criteriaBuilderQuery);
            if(limit != 0) query.setMaxResults(limit);
            query.setFirstResult(offset);
            List res = query.getResultList();
            session.getTransaction().commit();
            return res;
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
    public SearchApartmentEntity getApartmentSales(int idApart) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  c " +
                    "from SearchApartmentEntity c " +
                    "left join fetch c.apartmentSalesByIdApartment " +
                    "where c.idApartment = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idApart);
            SearchApartmentEntity res = (SearchApartmentEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
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
    public SearchApartmentEntity getSearchApartmentById(int idApart) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from SearchApartmentEntity where idApartment = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idApart);
            SearchApartmentEntity res = (SearchApartmentEntity) query.getSingleResult();
            session.getTransaction().commit();
            return res;
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
