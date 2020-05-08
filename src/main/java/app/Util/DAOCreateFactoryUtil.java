package app.Util;

import app.DAO.ApartmentDAOImpl;
import app.DAO.CityDAOImpl;
import app.DAO.ClientDAOImpl;
import app.DAO.DAOinterfaces.ApartmentDAO;
import app.DAO.DAOinterfaces.CityDAO;
import app.DAO.DAOinterfaces.ClientDAO;
import app.DAO.DAOinterfaces.DocumentDAO;
import app.DAO.DocumentDAOImpl;

public class DAOCreateFactoryUtil {

    private static DAOCreateFactoryUtil instance = null;
    private static CityDAO cityDAO = null;
    private static ClientDAO clientDAO = null;
    private static DocumentDAO documentDAO = null;
    private static ApartmentDAO apartmentDAO = null;

    public static DAOCreateFactoryUtil getInstance() {
        if (instance == null) {
            instance = new DAOCreateFactoryUtil();
        }
        return instance;
    }

    public CityDAO getCityDAO() {
        if (cityDAO == null) {
            cityDAO = new CityDAOImpl();
        }
        return cityDAO;
    }

    public ClientDAO getClientDAO() {
        if (clientDAO == null) {
            clientDAO = new ClientDAOImpl();
        }
        return clientDAO;
    }

    public DocumentDAO getDocumentDAO() {
        if (documentDAO == null) {
            documentDAO = new DocumentDAOImpl();
        }
        return documentDAO;
    }
    public ApartmentDAO getApartmentDAO() {
        if (apartmentDAO == null) {
            apartmentDAO = new ApartmentDAOImpl() {
            };
        }
        return apartmentDAO;
    }
}
