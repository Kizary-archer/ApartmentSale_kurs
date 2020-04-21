package app.Util;

import app.DAO.CityDAOImpl;
import app.DAO.ClientDAOImpl;
import app.DAO.DAOinterfaces.CityDAO;
import app.DAO.DAOinterfaces.ClientDAO;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static CityDAO cityDAO = null;
    private static ClientDAO clientDAO = null;

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
    public ClientDAO getClientDAO() {
        if (clientDAO == null){
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }
}
