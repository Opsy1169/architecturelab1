package services.cars;

import entities.Car;

import javax.ejb.Local;
import java.util.List;
import java.util.UUID;


public interface CarService {
    public static final String NAME = "CarService";

    List<Car> getAllCars();

    Car getCarById(UUID id);

    void saveCar(Car car);

    void updateCar(Car car);

    void deleteCar(Car car);

    void fillCarFields(Car car, String model, String manufacturer, Integer doorCount, String modelCode,
                       Boolean isElectrocar, String description);
}
