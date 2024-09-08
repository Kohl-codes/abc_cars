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

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.CarBidding;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.entity.UserProfile;
import lithan.abc.cars.service.AdminService;
import lithan.abc.cars.service.UserCarService;
import lithan.abc.cars.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  @Autowired
  private AdminService adminService;

  @Autowired
  private UserCarService userCarService;

  @Autowired
  private UserService userService;

  @GetMapping("")
  public String admin() {

    return "redirect:/admin/dashboard";
  }

  @GetMapping("/dashboard")
  public String dashboard(Model model, HttpSession session) {
    List<UserAccount> listUser = adminService.listUser();
    List<UserAccount> listAdmin = adminService.listAdmin();

    model.addAttribute("listUser", listUser);
    model.addAttribute("listAdmin", listAdmin);

    UserAccount user = userService.getUserLogin();
    UserProfile profile = user.getProfile();
    session.setAttribute("profileLog", profile);

    return "admin/dashboard";
  }

  // Edit User
  @GetMapping("/edit-user")
  public String editUser(@RequestParam("id") int id, Model model) {
    UserProfile profile = adminService.getProfileById(id);

    model.addAttribute("profile", profile);

    return "admin/edit-user";
  }

  @PostMapping("/editProfileProcess")
  public String saveEditUser(@Valid @ModelAttribute("profile") UserProfile profile, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      return "admin/edit-user";
    }

    adminService.editUser(profile);

    return "redirect:/admin/dashboard";
  }

  // Mark Admin
  @GetMapping("/mark-admin/{idUser}")
  public String markAdmin(@PathVariable("idUser") int id) {
    adminService.markAsAdmin(id);

    return "redirect:/admin/dashboard";
  }

  // Car Management
  @GetMapping("/car-management")
  public String carManagement(Model model) {
    List<Car> listCar = adminService.listCar();
    List<CarBidding> listCarBid = adminService.listCarBid();

    model.addAttribute("listCar", listCar);
    model.addAttribute("listCarBid", listCarBid);

    return "admin/car-management";
  }

  // DEACTIVATE CAR POST
  @GetMapping("/deactivate/{idCar}")
  public String deactivateCarPost(@PathVariable("idCar") int id) {
    userCarService.deactivateCarPost(id);

    return "redirect:/admin/car-management";
  }

  // ACTIVATE CAR POST
  @GetMapping("/activate/{idCar}")
  public String activateCarPost(@PathVariable("idCar") int id) {
    userCarService.activateCarPost(id);

    return "redirect:/admin/car-management";
  }

  // APPROVE BID CAR
  @GetMapping("/approve-bid/{idBid}")
  public String approveBidCarPost(@PathVariable("idBid") int id) {
    adminService.approveCarBid(id);

    return "redirect:/admin/car-management";
  }

  // DENY BID CAR
  @GetMapping("/deny-bid/{idBid}")
  public String denyBidCarPost(@PathVariable("idBid") int id) {
    adminService.denyCarBid(id);

    return "redirect:/admin/car-management";
  }
}
