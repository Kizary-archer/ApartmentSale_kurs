package app.DAO.DAOinterfaces;

import app.entities.ClientEntity;
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
                p.add(criteriaBuilder.like(root.get("name"),searchApartmentEntity.getName()));
            }
            if(searchApartmentEntity.getLivingSpace() != null){
                p.add(criteriaBuilder.like(root.get("surname"),searchApartmentEntity.getSurname()));
            }
            if(searchApartmentEntity.getStreet() != null){
                p.add(criteriaBuilder.like(root.get("patronymic"),searchApartmentEntity.getPatronymic()));
            }
            if(searchApartmentEntity.getDistrict() != null){
                p.add(criteriaBuilder.like(root.get("DateOfBirth"),searchApartmentEntity.getDateOfBirth().toString()));
            }
            if(searchApartmentEntity.getCity() != null){
                p.add(criteriaBuilder.like(root.get("Email"),searchApartmentEntity.getEmail()));
            }
            if(searchApartmentEntity.getClient() != 0){
                p.add(criteriaBuilder.like(root.get("gender"),searchApartmentEntity.getGender().toString()));
            }
            if(searchApartmentEntity.getPhoneNumber() != null){
                p.add(criteriaBuilder.like(root.get("PhoneNumber"),searchApartmentEntity.getPhoneNumber()));
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
        return null;
    }

    @Override
    public SearchApartmentEntity getSearchApartmentById(int idApart) {
        return null;
    }
}
