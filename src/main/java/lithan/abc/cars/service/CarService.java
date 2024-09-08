package lithan.abc.cars.service;

import java.util.List;

import lithan.abc.cars.entity.Car;

public interface CarService {

  Car getCarById(int id);

  List<Car> listCar();

  List<Car> searchCar(String keyword);

  List<Car> searchCarByPriceRange(int low, int high);

  List<Car> searchCarByKeywordAndPriceRange(String keyword, int low, int high);

  List<Car> featuredCars();
}