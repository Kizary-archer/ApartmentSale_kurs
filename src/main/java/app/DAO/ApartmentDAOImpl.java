package app.DAO;

import app.DAO.DAOinterfaces.ApartmentDAO;
import app.DAO.DAOinterfaces.ClientDAO;
import app.entities.ApartmentEntity;
import app.entities.ClientEntity;
import app.entities.HouseEntity;
import app.entities.houseView;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ApartmentDAOImpl implements ApartmentDAO {

    @Override
    public List<houseView> getHousesView(int limit, int offset, houseView houseView) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<houseView> criteriaBuilderQuery = criteriaBuilder.createQuery(houseView.class);
            Root<houseView> root = criteriaBuilderQuery.from(houseView.class);
            criteriaBuilderQuery.select(root);
            List<Predicate> p = new ArrayList<Predicate>();

            if(houseView.getIdHouse() != null){
                p.add(criteriaBuilder.equal(root.get("idHouse"),houseView.getIdHouse()));
            }
            if(houseView.getNumberHouse() != null){
                p.add(criteriaBuilder.like(root.get("numberHouse"),houseView.getNumberHouse()));
            }
            if(houseView.getNameSeries() != null){
                p.add(criteriaBuilder.like(root.get("nameSeries"),houseView.getNameSeries()));
            }
            if(houseView.getNameStreet() != null){
                p.add(criteriaBuilder.like(root.get("nameStreet"),houseView.getNameStreet()));
            }
            if(houseView.getNameDistrict() != null){
                p.add(criteriaBuilder.like(root.get("nameDistrict"),houseView.getNameDistrict()));
            }
            if(houseView.getNameCity() != null){
                p.add(criteriaBuilder.like(root.get("nameCity"),houseView.getNameCity()));
            }
            if(!p.isEmpty()) {
                Predicate[] pr = new Predicate[p.size()];
                p.toArray(pr);
                criteriaBuilderQuery.where((pr));
            }
            Query query = session.createQuery(criteriaBuilderQuery);
           if(limit != 0) query.setMaxResults(limit);
            query.setFirstResult(offset);
            List<houseView> res = query.getResultList();
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
    public ApartmentEntity getApartmentAllChild(int idApartment) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct  a " +
                    "from ApartmentEntity a " +
                    "left join fetch a.apartmentSalesByIdApartment " +
                    "where a.idApartment = :idApartment";
            Query query =  session.createQuery(hql);
            query.setParameter("idApartment",idApartment);
            ApartmentEntity res = (ApartmentEntity) query.getSingleResult();
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
    public ApartmentEntity getApartmentById(int idApartment) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from ApartmentEntity where idApartment = :idApartment";
            Query query =  session.createQuery(hql);
            query.setParameter("idApartment",idApartment);
            ApartmentEntity res = (ApartmentEntity) query.getSingleResult();
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
