package app;

import app.entities.*;
import app.services.ClientService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String args[]) throws SQLException {
        ClientService clientService = new ClientService();
   // boolean test = clientService.addClient("aaa","aaa","aaa",new Date(1989-03-19),"2222222","aass",false);
       ClientEntity clientEntity = clientService.getClientById(1);
       clientEntity.setApartmentsByIdClient(clientService.getClientapartments(1));
       clientEntity.setSearchApartmentsByIdClient(clientService.getClientsearchApartments(1));
      // List res = (List) clientService.getClientDocuments(clientService.getClientById(1));
        //List<ClientEntity> cl = (List<ClientEntity>) clientService.getAllClient();
        //ClientEntity clientEntity = clientService.getClientAllData(clientService.getClientById(1));
     /* ClientEntity  clientEntity = clientService.getClientById(1);
      ApartmentEntity apartmentEntity = new ApartmentEntity();
      apartmentEntity.setApartmentOwner(1);
      apartmentEntity.setCountRoom(1);
      apartmentEntity.setHouse(1);
      apartmentEntity.setLivingSpace(1);
      apartmentEntity.setMeterPrice(1);
      apartmentEntity.setNumberApartment(1);
        List<ApartmentEntity> mm = new ArrayList<ApartmentEntity>();
        mm.add(apartmentEntity);
      clientEntity.setApartmentsByIdClient(mm);
      clientService.updateClient(clientEntity);*/

    }
}
