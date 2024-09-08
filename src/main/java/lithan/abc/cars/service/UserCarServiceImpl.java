package lithan.abc.cars.service;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lithan.abc.cars.entity.Car;
import lithan.abc.cars.entity.CarBidding;
import lithan.abc.cars.entity.CarPicture;
import lithan.abc.cars.entity.TestDrive;
import lithan.abc.cars.entity.UserAccount;
import lithan.abc.cars.repository.CarBiddingRepository;
import lithan.abc.cars.repository.CarPictureRepository;
import lithan.abc.cars.repository.CarRepository;
import lithan.abc.cars.repository.TestDriveRepository;

@Service
public class UserCarServiceImpl implements UserCarService {

  @Autowired
  private UserService userService;

  @Autowired
  private CarRepository carRepo;

  @Autowired
  private CarPictureRepository carPictureRepo;

  @Autowired
  private CarBiddingRepository carBidRepo;

  @Autowired
  private TestDriveRepository testDriveRepo;

  @Override
  public List<Car> listUserCar() {
    List<Car> listUserCar = carRepo.findAll();
    UserAccount user = userService.getUserLogin();

    listUserCar.removeIf(car -> car.getUser() != user);

    return listUserCar;
  }

  @Override
  public void postCar(MultipartFile file, Car car) throws Exception {
    UserAccount user = userService.getUserLogin();
    CarPicture picture = new CarPicture();
    CarBidding carBidding = new CarBidding();

    picture.setFileName(file.getOriginalFilename());
    picture.setFileType(file.getContentType());
    picture.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
    picture.setCar(car);

    car.setCarPicture(picture);
    car.setStatus("ACTIVE");
    car.setUser(user);

    carBidding.setCar(car);
    carBidding.setUser(user);
    carBidding.setBidPrice(0);
    carBidding.setStatus("STARTING");

    carRepo.save(car);
    carBidRepo.save(carBidding);
  }

  @Override
  public void editCar(Car car) {
    Car editedCar = carRepo.findById(car.getIdCar()).get();

    editedCar.setMake(car.getMake());
    editedCar.setModel(car.getModel());
    editedCar.setYear(car.getYear());
    editedCar.setPrice(car.getPrice());

    carRepo.save(editedCar);
  }

  @Override
  public void activateCarPost(int id) {
    Car editedCar = carRepo.findById(id).get();

    editedCar.setStatus("ACTIVE");

    carRepo.save(editedCar);
  }

  @Override
  public void deactivateCarPost(int id) {
    Car editedCar = carRepo.findById(id).get();

    editedCar.setStatus("DEACTIVE");

    carRepo.save(editedCar);
  }

  @Override
  public List<CarBidding> listCarBid() {
    List<CarBidding> listCarBid = carBidRepo.findAll();

    return listCarBid;
  }

  @Override
  public Car getCarById(int id) {
    Car car = carRepo.findById(id).get();

    return car;
  }

  @Override
  public void postCarBidding(CarBidding carBidding) {
    carBidding.setStatus("ONGOING");
    carBidRepo.save(carBidding);
  }

  @Override
  public int highestBidding(int idCar) {
    int carBidding = carBidRepo.highestBid(idCar);

    return carBidding;
  }

  @Override
  public void saveTestDrive(String date, UserAccount user, Car car) {
    TestDrive testDrive = new TestDrive();

    testDrive.setDate(date);
    testDrive.setCar(car);
    testDrive.setUser(user);

    testDriveRepo.save(testDrive);
  }

  @Override
  public List<TestDrive> listTestDrive() {
    List<TestDrive> listTestDrive = testDriveRepo.findAll();

    return listTestDrive;
  }

  @Override
  public void saveUploadPicture(MultipartFile file, Car car) throws Exception {
    try {
      CarPicture picture = car.getCarPicture();

      picture.setFileName(file.getOriginalFilename());
      picture.setFileType(file.getContentType());
      picture.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
      picture.setCar(car);

      carPictureRepo.save(picture);
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}