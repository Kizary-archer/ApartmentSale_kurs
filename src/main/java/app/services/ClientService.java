package app.services;

import app.DAO.DAOinterfaces.ClientDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entities.*;

import java.sql.Date;
import java.util.Collection;

public class ClientService {

    public boolean addClient(String name,
                             String surname,
                             String patronymic,
                             Date dateOfBirth,
                             String phoneNumber,
                             String email,
                             Boolean gender) {
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
      return clientDAO.add(new ClientEntity( name, surname, patronymic, dateOfBirth, phoneNumber, email, gender));
    }
    public boolean addClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.add(clientEntity);
    }
    public boolean delClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.delete(clientEntity);
    }
    public boolean updClient(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.update(clientEntity);
    }
    public ClientEntity getClientById(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientById(idClient);
    }
    public Collection<ClientEntity> getClients(int limit,int offset,ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClients(limit,offset,clientEntity);
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
    public ClientEntity getClientAllData(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return clientDAO.getClientAllChild(idClient);
    }
}
