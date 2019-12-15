package services.cars;

import dao.AbstractDao;
import dao.CarDao;
import dao.Dao;
import dao.ShowroomDao;
import entities.Car;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.List;
import java.util.UUID;


@Stateless(name = CarService.NAME)
@Local(value = CarService.class)
public class CarServiceImpl implements CarService {
//    private ShowroomDao dao;
//    private static CarServiceImpl carService;
//
//    private CarServiceImpl() {
//        this.dao = ShowroomDao.getInstance();
//    }
//
//    public static CarServiceImpl getInstance() {
//        if (carService == null) {
//            carService = new CarServiceImpl();
//        }
//        return carService;
//    }

    @EJB(beanName = "CarDao")
    private Dao dao;

    @Override
    public List<Car> getAllCars() {
        return dao.getAll();
    }

    @Override
    public Car getCarById(UUID id) {
        return (Car) dao.getById(id);
    }


    @Override
    public void saveCar(Car car) {
        dao.saveEntity(car);
    }

    @Override
    public void updateCar(Car car) {
        dao.updateEntity(car);
    }

    @Override
    public void deleteCar(Car car) {
        dao.deleteEntity(car);
    }

    @Override
    public void fillCarFields(Car car, String model, String manufacturer, Integer doorCount, String modelCode,
                              Boolean isElectrocar, String description) {
        car.setModel(model);
        car.setManufacturer(manufacturer);
        car.setDoorCount(doorCount);
        car.setModelCode(modelCode);
        car.setElectrocar(isElectrocar);
        car.setDecription(description);
    }

}
