package lithan.abc.cars.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lithan.abc.cars.entity.ProfilePicture;
import lithan.abc.cars.entity.Role;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.entity.UserProfile;
import lithan.abc.cars.repository.ProfilePictureRepository;
import lithan.abc.cars.repository.UserProfileRepository;
import lithan.abc.cars.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepo;

  @Autowired
  private UserProfileRepository userProfileRepo;

  @Autowired
  private ProfilePictureRepository profilePictureRepo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public void saveUser(UserAccount user, UserProfile profile) {
    UserAccount saveUser = new UserAccount();

    List<Role> roles = new ArrayList<>();
    Role role = new Role();

    saveUser.setUsername(user.getUsername());
    saveUser.setPassword(passwordEncoder.encode(user.getPassword()));

    roles.add(role);

    for (Role r : roles) {
      r.setRole("ROLE_USER");
      r.setUser(saveUser);
    }

    profile.setUser(saveUser);

    saveUser.setProfile(profile);
    saveUser.setRoles(roles);
    saveUser.setRole("USER");

    userRepo.save(saveUser);
  }

  @Override
  public UserAccount findByUsername(String username) {
    UserAccount user = userRepo.findByUsername(username);

    return user;
  }

  @Override
  public UserAccount getUserLogin() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    String username = authentication.getName();

    UserAccount user = userRepo.findByUsername(username);

    return user;
  }

  @Override
  public void saveImage(MultipartFile file, UserProfile profile) throws Exception {
    try {

      if (profile.getProfilePicture() == null) {
        // Set Profile Picture if no profile picture
        ProfilePicture picture = new ProfilePicture();

        picture.setFileName(file.getOriginalFilename());
        picture.setFileType(file.getContentType());
        picture.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        picture.setProfile(profile);

        profilePictureRepo.save(picture);

      } else {
        // Edit Profile Picture if profile picture exist
        ProfilePicture picture = profile.getProfilePicture();

        picture.setFileName(file.getOriginalFilename());
        picture.setFileType(file.getContentType());
        picture.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        picture.setProfile(profile);

        profilePictureRepo.save(picture);
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }

  }

  @Override
  public void editUserProfile(UserProfile profile) {
    UserProfile editedProfile = userProfileRepo.findById(profile.getIdProfile()).get();

    editedProfile.setFirstName(profile.getFirstName());
    editedProfile.setLastName(profile.getLastName());
    editedProfile.setPhoneNumber(profile.getPhoneNumber());
    editedProfile.setAddress(profile.getAddress());
    editedProfile.setAbout(profile.getAbout());

    userProfileRepo.save(editedProfile);
  }

  @Override
  public UserProfile getProfile(int idProfile) {
    UserProfile profile = userProfileRepo.findById(idProfile).get();

    return profile;
  }

}