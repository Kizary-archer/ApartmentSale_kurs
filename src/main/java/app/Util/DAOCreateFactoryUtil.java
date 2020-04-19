package app.Util;

import app.DAO.CityDAOImpl;
import app.DAO.DAOinterfaces.CityDAO;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static CityDAO cityDAO = null;

   public static DAOCreateFactoryUtil getInstance(){
       if (instance == null){
           instance = new DAOCreateFactoryUtil();
       }
       return instance;
   }

    public CityDAO getCityDAO() {
        if (cityDAO == null){
            cityDAO = new CityDAOImpl();
        }
        return cityDAO;
    }
}
