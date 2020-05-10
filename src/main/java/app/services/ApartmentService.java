package app.services;

import app.DAO.DAOinterfaces.ApartmentDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entities.ApartmentEntity;
import app.entities.HouseView;

import java.util.Collection;

public class ApartmentService {

    public boolean addApartment(ApartmentEntity apartmentEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.add(apartmentEntity);
    }
    public boolean delApartment(ApartmentEntity apartmentEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.delete(apartmentEntity);
    }
    public boolean updApartment(ApartmentEntity apartmentEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.update(apartmentEntity);
    }
    public ApartmentEntity getApartmentById(int idClient){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.getApartmentById(idClient);
    }
    public Collection<HouseView> getHouses(int limit, int offset, HouseView houseView){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.getHousesView(limit,offset,houseView);
    }
    public ApartmentEntity getApartmentAllChild(int idClient){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return apartmentDAO.getApartmentAllChild(idClient);
    }
}
