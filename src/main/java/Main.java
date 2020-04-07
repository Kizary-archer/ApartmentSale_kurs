import app.Util.HibernateSessionFactoryUtil;
import app.services.CityServices;
import app.entities.CityEntity;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;

import javax.persistence.metamodel.EntityType;

public class Main {

    public static Session getSession() throws HibernateException {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
               /* for (Object o : query.list()) {
                    System.out.println("  " + o);
                }*/
            }
        } finally {
            session.close();
        }
      //  CityServices cityServices = new CityServices();
      //  CityEntity city = new CityEntity("Санкт-Петербург");
       // cityServices.AddCity(city);
    }
}