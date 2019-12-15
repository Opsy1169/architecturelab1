package services.showrooms;

import dao.Dao;
import dao.ShowroomDao;
import entities.Showroom;
import services.cars.CarService;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;


@Stateless(name = "ShowroomService")
@Local(value = ShowroomService.class)
public class ShowroomServiceImpl implements ShowroomService {

    @EJB(beanName = "ShowroomDao")
    private Dao dao;

//    private static ShowroomDao dao;
//    private static ShowroomServiceImpl showroomService;
//
//    private ShowroomServiceImpl() {
//        this.dao = ShowroomDao.getInstance();
//    }
//
//    public static ShowroomServiceImpl getInstance() {
//        if (showroomService == null) {
//            showroomService = new ShowroomServiceImpl();
//        }
//        return showroomService;
//    }

    @Override
    public List<Showroom> getAllShowrooms() {
        return dao.getAll();
    }

    @Override
    public Showroom getShowroomById(UUID id) {
        return (Showroom) dao.getById(id);
    }

    @Override
    public void saveShowroom(Showroom showroom) {
        dao.saveEntity(showroom);
    }

    @Override
    public void updateShowroom(Showroom showroom) {
        dao.updateEntity(showroom);
    }

    @Override
    public void deleteShworoom(Showroom showroom) {
        dao.deleteEntity(showroom);
    }

    @Override
    public  void fillShowroomFields(Showroom showroom, String name, String address, Integer capacity){
        showroom.setName(name);
        showroom.setAddress(address);
        showroom.setCapacityInCars(capacity);
    }
}
