package app;

import app.entities.*;
import app.services.ClientService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main (String args[]) throws SQLException {
        ClientService clientService = new ClientService();
   // boolean test = clientService.addClient("aaa","aaa","aaa",new Date(1989-03-19),"2222222","aass",false);
     //  ClientEntity clientEntity = clientService.getClientById(1);
      // List res = (List) clientService.getClientDocuments(clientService.getClientById(1));
        //List<ClientEntity> cl = (List<ClientEntity>) clientService.getAllClient();
        //ClientEntity clientEntity = clientService.getClientAllData(clientService.getClientById(1));
      ClientEntity  clientEntity = clientService.getClientById(1);

    }
}
