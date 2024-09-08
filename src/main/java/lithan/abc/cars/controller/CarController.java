package lithan.abc.cars.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.service.CarService;
import lithan.abc.cars.service.UserCarService;

@Controller
@RequestMapping("/cars")
public class CarController {

  @Autowired
  private CarService carService;

  @Autowired
  private UserCarService userCarService;

  @GetMapping("")
  public String carPage(Model model) {
    List<Car> listCar = carService.listCar();

    model.addAttribute("listCar", listCar);

    return "cars";
  }

  // Car Details
  @GetMapping("/{make}/{model}/{year}/{id_car}")
  public String carDetails(@PathVariable("id_car") int id, Model model) {
    Car car = carService.getCarById(id);

    int higestBidding = userCarService.highestBidding(id);

    if (higestBidding == 0) {
    }

    model.addAttribute("car", car);
    model.addAttribute("highestBidding", higestBidding);

    return "car-details";
  }

  // Search Car
  @GetMapping(value = "", params = "keyword")
  public String searchCar(@RequestParam("keyword") String keyword, Model model) {

    List<Car> searchCar = carService.searchCar(keyword);

    model.addAttribute("listCar", searchCar);
    return "cars";
  }

  @GetMapping(value = "", params = { "low", "high" })
  public String searchCarByPriceRange(@RequestParam("low") int low, @RequestParam("high") int high, Model model) {

    List<Car> searchCar = carService.searchCarByPriceRange(low, high);

    model.addAttribute("listCar", searchCar);
    return "cars";
  }

}