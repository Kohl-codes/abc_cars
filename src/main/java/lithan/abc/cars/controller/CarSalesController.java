package lithan.abc.cars.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.CarBidding;
import lithan.abc.cars.entity.TestDrive;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.service.UserCarService;
import lithan.abc.cars.service.UserService;

@Controller
public class CarSalesController {

  @Autowired
  private UserService userService;

  @Autowired
  private UserCarService userCarService;

  // Car bidding
  @GetMapping("/car-bid")
  public String postBidding(@RequestParam("id") int id, Model model, HttpSession session) {
    Car car = userCarService.getCarById(id);
    UserAccount user = userService.getUserLogin();

    CarBidding carBidding = new CarBidding();
    int higestBidding = userCarService.highestBidding(id);

    model.addAttribute("user", user);
    model.addAttribute("car", car);
    model.addAttribute("carBidding", carBidding);
    session.setAttribute("highestBidding", higestBidding);

    return "user/car-bid";
  }

  @PostMapping("/postCarBidding")
  public String saveCarBidding(@ModelAttribute("carBidding") CarBidding carBidding,
      @RequestParam("highestBidding") int highestBidding, Model model, HttpSession session) {

    Car car = carBidding.getCar();

    if (carBidding.getBidPrice() <= highestBidding || carBidding.getBidPrice() <= car.getPrice()) {
      int higestBidding = (int) session.getAttribute("highestBidding");
      model.addAttribute("highestBidding", higestBidding);
      model.addAttribute("carBidding", carBidding);
      model.addAttribute("car", car);
      model.addAttribute("message", "Bid Price can't lower than or equal to listed price");
      return "user/car-bid";
    }

    userCarService.postCarBidding(carBidding);
    session.removeAttribute("highestBidding");
    return "redirect:/cars/" + car.getMake() + "/" + car.getModel() + "/" + car.getYear() + "/" + car.getIdCar();
  }

  // Test Drive Car
  @GetMapping("/test-drive/{idCar}")
  public String testDrive(@PathVariable("idCar") int idCar, Model model) {
    TestDrive testDrive = new TestDrive();
    UserAccount user = userService.getUserLogin();
    Car car = userCarService.getCarById(idCar);

    model.addAttribute("testDrive", testDrive);
    model.addAttribute("user", user);
    model.addAttribute("car", car);

    return "user/test-drive";
  }

  @PostMapping("/test-drive/testDriveProcess")
  public String saveTestDrive(@ModelAttribute("testDrive") TestDrive testDrive) {
    userCarService.saveTestDrive(testDrive.getDate(), testDrive.getUser(), testDrive.getCar());
    return "redirect:/";
  }

}
