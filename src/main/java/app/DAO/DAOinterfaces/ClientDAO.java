package app.DAO.DAOinterfaces;

import app.entities.ClientEntity;

import java.util.Collection;

public interface ClientDAO extends DAOMain {

    public boolean addClient(ClientEntity clientEntity);
    public boolean delClient(ClientEntity clientEntity);
    public Collection<ClientEntity> getAllClient();
    public Collection<ClientEntity> getClients(int limit,int offset);
    public ClientEntity getClientDocument(int idClient);
    public ClientEntity getClientapartmentSales(int idClient);
    public ClientEntity getClientapartments(int idClient);
    public ClientEntity getClientsearchApartments(int idClient);
    public ClientEntity getClientById(int idClient);
}
