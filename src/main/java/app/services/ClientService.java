package app.services;

import app.DAO.DAOinterfaces.CityDAO;
import app.DAO.DAOinterfaces.ClientDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entities.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;

public class ClientService {

    public boolean addClient(String name,
                             String surname,
                             String patronymic,
                             Date dateOfBirth,
                             String phoneNumber,
                             String email,
                             Boolean gender) throws SQLException {
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
      return clientDAO.addClient(new ClientEntity( name, surname, patronymic, dateOfBirth, phoneNumber, email, gender));
    }
    public boolean delClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.delClient(clientEntity);
    }
    public static boolean updateClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.updateClient(clientEntity);
    }
    public ClientEntity getClientById(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientById(idClient);
    }
    public Collection<ClientEntity> getClients(int limit,int offset){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClients(limit,offset);
    }

    public Collection<DocumentsClientEntity> getClientDocuments(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientDocument(idClient).getDocumentsClientsByIdClient();
    }
    public Collection<ApartmentSaleEntity> getClientapartmentSales(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientapartmentSales(idClient).getApartmentSalesByIdClient();
    }
    public Collection<ApartmentEntity> getClientapartments(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientapartments(idClient).getApartmentsByIdClient();
    }
    public Collection<SearchApartmentEntity> getClientsearchApartments(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientsearchApartments(idClient).getSearchApartmentsByIdClient();
    }
    public Collection<ClientEntity> getAllClient(){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return clientDAO.getAllClient();
    }
  /*  public ClientEntity getClientAllData(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientDocument(clientDAO.getClientapartments(
                                                clientDAO.getClientapartmentSales
                                                    (clientDAO.getClientsearchApartments(clientEntity))));
    }*/
}
