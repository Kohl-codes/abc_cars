package lithan.abc.cars.service;

import org.springframework.web.multipart.MultipartFile;

import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.entity.UserProfile;

public interface UserService {

  void saveUser(UserAccount user, UserProfile profile);

  UserAccount findByUsername(String username);

  UserAccount getUserLogin();

  void saveImage(MultipartFile file, UserProfile profile) throws Exception;

  void editUserProfile(UserProfile profile);

  UserProfile getProfile(int idProfile);
}