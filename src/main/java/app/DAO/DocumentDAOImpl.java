package app.DAO;

import app.DAO.DAOinterfaces.ClientDAO;
import app.DAO.DAOinterfaces.DocumentDAO;
import app.entities.ClientEntity;
import app.entities.DocumentTypeEntity;
import app.entities.DocumentsClientEntity;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DocumentDAOImpl implements DocumentDAO {

    @Override
    public DocumentsClientEntity getDocumentById(int idDocument) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "from DocumentsClientEntity where idDocument = :id";
            Query query =  session.createQuery(hql);
            query.setParameter("id",idDocument);
            DocumentsClientEntity res = (DocumentsClientEntity) query.getSingleResult();
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
    public List<DocumentTypeEntity> getAllDocumentType(int limit, int offset) {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String hql = "select distinct d from DocumentTypeEntity d ";
            Query query = session.createQuery(hql);
            query.setFirstResult(offset);
            if(limit != 0) query.setMaxResults(limit);
            List<DocumentTypeEntity> res = query.getResultList();
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
