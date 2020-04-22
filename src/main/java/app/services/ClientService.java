package app.services;

import app.DAO.DAOinterfaces.CityDAO;
import app.DAO.DAOinterfaces.ClientDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entities.CityEntity;
import app.entities.ClientEntity;

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
    public ClientEntity getClientById(int idClient){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientById(idClient);
    }

    public Collection<ClientEntity> getClientDocuments(ClientEntity clientEntity){
        ClientDAO clientDAO = DAOCreateFactoryUtil.getInstance().getClientDAO();
        return  clientDAO.getClientDocument(clientEntity);
    }
}
