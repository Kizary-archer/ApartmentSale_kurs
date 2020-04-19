package app.DAO.DAOinterfaces;

import app.entities.ClientEntity;

public interface ClientDAO extends DAOMain {

    public boolean addUser(ClientEntity clientEntity);
}
