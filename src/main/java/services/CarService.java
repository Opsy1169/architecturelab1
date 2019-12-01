package services;

import dao.DAO;
import entities.Car;

import java.util.List;
import java.util.UUID;

public class CarService {
    private DAO dao;
    private static CarService carService;

    private CarService() {
        this.dao = DAO.getInstance();
    }

    public static CarService getInstance() {
        if (carService == null) {
            carService = new CarService();
        }
        return carService;
    }

    public List<Car> getAllCars() {
        return dao.getAllCars();
    }

    public Car getCarById(UUID id) {
        return dao.getCarById(id);
    }


    public void saveCar(Car car) {
        dao.saveEntity(car);
    }

    public void updateCar(Car car) {
        dao.updateEntity(car);
    }

    public void deleteCar(Car car) {
        dao.deleteEntity(car);
    }

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
