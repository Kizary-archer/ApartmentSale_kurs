package app.services;

import app.DAO.DAOinterfaces.ApartmentDAO;
import app.Util.DAOCreateFactoryUtil;
import app.entities.ApartmentEntity;
import app.entities.HouseEntity;

import java.util.Collection;

public class ApartmentService {

    public boolean addApartment(ApartmentEntity apartmentEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.add(apartmentEntity);
    }
    public boolean delpartment(ApartmentEntity apartmentEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.delete(apartmentEntity);
    }
    public boolean updpartment(ApartmentEntity apartmentEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.update(apartmentEntity);
    }
    public ApartmentEntity getpartmentById(int idClient){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.getApartmentById(idClient);
    }
    public Collection<HouseEntity> getHouses(int limit,int offset,HouseEntity houseEntity){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return  apartmentDAO.getHouses(limit,offset,houseEntity);
    }
    public ApartmentEntity getApartmentAllChild(int idClient){
        ApartmentDAO apartmentDAO = DAOCreateFactoryUtil.getInstance().getApartmentDAO();
        return apartmentDAO.getApartmentAllChild(idClient);
    }
}
