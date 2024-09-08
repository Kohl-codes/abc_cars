package lithan.abc.cars.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.entity.UserProfile;
import lithan.abc.cars.service.UserService;

@Controller
@RequestMapping("/register")
public class RegisterController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public String register() {

    return "redirect:/register/account";
  }

  // Register Account
  @GetMapping("/account")
  public String registerAccount(Model model) {
    UserAccount user = new UserAccount();
    model.addAttribute("account", user);

    return "register-account";
  }

  
  @PostMapping("/accountProcess")
  public String registerAccountProcess(
      @Valid @ModelAttribute("account") UserAccount user,
      BindingResult bindingResult, HttpSession session) {

    if (bindingResult.hasErrors()) {
      return "register-account";
    }

    session.setAttribute("registerAccount", user);

    return "redirect:/register/profile";
  }

  // Register Profile
  @GetMapping("/profile")
  public String registerProfile(Model model) {
    UserProfile profile = new UserProfile();

    model.addAttribute("profile", profile);

    return "register-profile";
  }

  @PostMapping("/profileProcess")
  public String registerProfileProcess(
      @Valid @ModelAttribute("profile") UserProfile profile,
      BindingResult bindingResult, HttpSession session) {

    if (bindingResult.hasErrors()) {
      return "register-profile";
    }

    UserAccount user = (UserAccount) session.getAttribute("registerAccount");

    userService.saveUser(user, profile);

    return "redirect:/register/thank-you";
  }

  // Thank You
  @GetMapping("thank-you")
  public String thankYou(HttpSession session) {
    session.invalidate();

    return "thank-you";
  }
}