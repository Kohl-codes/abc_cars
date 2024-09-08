package lithan.abc.cars.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.TestDrive;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.service.UserCarService;
import lithan.abc.cars.service.UserService;

@Controller
@RequestMapping("/user")
public class UserCarController {

  @Autowired
  private UserCarService userCarService;

  @Autowired
  private UserService userService;

  // User Posted Car
  @GetMapping("/my-posted-car")
  public String myPostedCarPage(Model model) {
    List<Car> userCar = userCarService.listUserCar();

    model.addAttribute("userCar", userCar);

    return "user/my-posted-car";
  }

  // Posting Car
  @GetMapping("/post-car")
  public String postCar(Model model) {
    Car car = new Car();

    model.addAttribute("car", car);

    return "user/post-car";
  }

  @PostMapping("/postCarProcess")
  public String postCarProcess(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult,
      @RequestParam("imageFile") MultipartFile file, Model model) {

    if (bindingResult.hasErrors()) {
      return "user/post-car";
    }

    if (file.isEmpty()) {
      model.addAttribute("fileError", "Car Picture is required");
      return "user/post-car";
    }

    try {
      userCarService.postCar(file, car);
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }

    return "redirect:/user/my-posted-car";
  }

  // Edit Posted Car
  @GetMapping("/edit-posted-car")
  public String editPostedCar(@RequestParam("id") int id, Model model) {
    List<Car> userCars = userCarService.listUserCar();

    // Check if the user that access the link is the owned the posted car
    for (Car car : userCars) {
      if (car.getIdCar() == id) {
        model.addAttribute("car", car);
        return "user/edit-posted-car";
      }
    }

    // If unauthorized user tried to access the edit post car
    return "redirect:/user/my-posted-car";
  }

  @PostMapping("/editCarProcess")
  public String saveEditCar(@Valid @ModelAttribute("car") Car car, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "user/edit-posted-car";
    }

    userCarService.editCar(car);

    return "redirect:/cars/" + car.getMake() + "/" + car.getModel() + "/" + car.getYear() + "/" + car.getIdCar();
  }

  // Activate & Deactivate Posted Car
  @GetMapping("/activate/{idCar}")
  public String activatePostedCar(@PathVariable("idCar") int id) {

    userCarService.activateCarPost(id);

    return "redirect:/user/my-posted-car";
  }

  @GetMapping("/deactivate/{idCar}")
  public String deactivatePostedCar(@PathVariable("idCar") int id) {

    userCarService.deactivateCarPost(id);

    return "redirect:/user/my-posted-car";
  }

  // List Test Drive
  @GetMapping("/test-drive")
  public String listTestDrive(Model model) {
    UserAccount user = userService.getUserLogin();
    List<TestDrive> listTestDrive = userCarService.listTestDrive();

    listTestDrive.removeIf(test -> test.getCar().getUser().getIdUser() != user.getIdUser());

    model.addAttribute("listTestDrive", listTestDrive);

    return "user/list-test-drive";
  }

  // Upload Car Picture
  @GetMapping("/upload-car-picture")
  public String uploadPicture(@RequestParam("idCar") int idCar, HttpSession session) {
    session.setAttribute("idCar", idCar);

    return "user/upload-car-picture";
  }

  @PostMapping("/uploadCarPicture")
  public String uploadCarImage(@RequestParam("imageFile") MultipartFile imageFile, Model model, HttpSession session) {
    String type = imageFile.getContentType();

    if (type != null && (type.equals("image/jpg") || type.equals("image/jpeg") || type.equals("image/png"))) {
      Car car = userCarService.getCarById((int) session.getAttribute("idCar"));

      try {
        userCarService.saveUploadPicture(imageFile, car);
      } catch (Exception e) {
        e.printStackTrace();
      }

      return "redirect:/cars";
    }

    model.addAttribute("message", "File type not suported");
    return "user/upload-car-picture";
  }

}
