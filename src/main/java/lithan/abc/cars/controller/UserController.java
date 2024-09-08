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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lithan.abc.cars.entity.ProfilePicture;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.entity.UserProfile;
import lithan.abc.cars.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("")
  public String user() {
    return "redirect:/user/my-profile";
  }

  @GetMapping("/my-profile")
  public String myProfile(Model model, HttpSession session) {
    UserAccount user = userService.getUserLogin();
    UserProfile profile = user.getProfile();
    ProfilePicture picture = profile.getProfilePicture();

    model.addAttribute("profile", profile);
    model.addAttribute("picture", picture);

    session.setAttribute("profileLog", profile);

    return "user/my-profile";
  }

  // Edit Profile
  @GetMapping("/edit-profile")
  public String editProfile(Model model) {
    UserAccount user = userService.getUserLogin();
    UserProfile profile = user.getProfile();

    model.addAttribute("profile", profile);
    return "user/edit-profile";
  }

  @PostMapping("/editProfileProcess")
  public String saveEditProfile(@Valid @ModelAttribute("profile") UserProfile profile, BindingResult bindingResult,
      HttpSession session) {
    if (bindingResult.hasErrors()) {
      return "user/edit-profile";
    }

    userService.editUserProfile(profile);

    session.setAttribute("profileLog", profile);

    return "redirect:/user/my-profile";
  }

  // Upload Profile Picture
  @GetMapping("/upload-picture")
  public String uploadPicture() {
    return "user/upload-picture";
  }

  @PostMapping("/uploadPicture")
  public String uploadProfileImage(@RequestParam("imageFile") MultipartFile imageFile, Model model,
      HttpSession session) {
    String type = imageFile.getContentType();

    if (type != null && (type.equals("image/jpg") || type.equals("image/jpeg") || type.equals("image/png"))) {
      UserAccount user = userService.getUserLogin();
      UserProfile profile = user.getProfile();

      try {
        userService.saveImage(imageFile, profile);
        session.setAttribute("profileLog", profile);
      } catch (Exception e) {
        e.printStackTrace();
      }

      return "redirect:/user/my-profile";
    }

    model.addAttribute("message", "File type not suported");
    return "user/upload-picture";
  }

}