package app.DAO.DAOinterfaces;

import app.entities.ClientEntity;

import java.util.Collection;

public interface ClientDAO extends DAOMain {

    public boolean addClient(ClientEntity clientEntity);
    public Collection<ClientEntity> getAllClient();
    public Collection<ClientEntity> getClientDocument(ClientEntity clientEntity);
    public ClientEntity getClientById(int idClient);
}
