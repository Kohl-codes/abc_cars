package lithan.abc.cars.service;

import java.util.List;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.CarBidding;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.entity.UserProfile;

public interface AdminService {

  void editUser(UserProfile profile);

  void markAsAdmin(int idUser);

  UserProfile getProfileById(int idCar);

  List<UserAccount> listUser();

  List<UserAccount> listAdmin();

  List<Car> listCar();

  List<CarBidding> listCarBid();

  void approveCarBid(int idBid);

  void denyCarBid(int idBid);
}