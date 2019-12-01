package services;

import dao.DAO;
import entities.Showroom;

import java.util.List;
import java.util.UUID;

public class ShowroomService {

    private static DAO dao;
    private static ShowroomService showroomService;

    private ShowroomService() {
        this.dao = DAO.getInstance();
    }

    public static ShowroomService getInstance() {
        if (showroomService == null) {
            showroomService = new ShowroomService();
        }
        return showroomService;
    }

    public List<Showroom> getAllShowrooms() {
        return dao.getAllShowrooms();
    }

    public Showroom getShowroomById(UUID id) {
        return dao.getShowroomById(id);
    }

    public void saveShowroom(Showroom showroom) {
        dao.saveEntity(showroom);
    }

    public void updateShowroom(Showroom showroom) {
        dao.updateEntity(showroom);
    }

    public void deleteShworoom(Showroom showroom) {
        dao.deleteEntity(showroom);
    }

    public  void fillShowroomFields(Showroom showroom, String name, String address, Integer capacity){
        showroom.setName(name);
        showroom.setAddress(address);
        showroom.setCapacityInCars(capacity);
    }
}
