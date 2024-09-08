package lithan.abc.cars.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_car")
public class Car {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_car")
  private int idCar;

  @NotBlank(message = "Make is required")
  @Column(nullable = false)
  private String make;

  @NotBlank(message = "Model is required")
  @Column(nullable = false)
  private String model;

  @NotEmpty(message = "Year is required")
  @Size(min = 4, max = 4, message = "Year must be 4 characters long")
  @Column(nullable = false)
  private String year;

  @Column(nullable = false)
  private String status;

  @Column(nullable = false)
  @Digits(integer = 10, fraction = 2)
  @Positive(message = "Price can't below 0 or Negative number")
  private int price;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private UserAccount user;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "car")
  private CarPicture carPicture;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "car")
  private List<CarBidding> carBiddings;

  public Car() {
  }

  public String getMake() {
    return make;
  }

  public void setMake(String make) {
    this.make = make;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public UserAccount getUser() {
    return user;
  }

  public void setUser(UserAccount user) {
    this.user = user;
  }

  public CarPicture getCarPicture() {
    return carPicture;
  }

  public void setCarPicture(CarPicture carPicture) {
    this.carPicture = carPicture;
  }

  public int getIdCar() {
    return idCar;
  }

  public void setIdCar(int idCar) {
    this.idCar = idCar;
  }

  public List<CarBidding> getCarBiddings() {
    return carBiddings;
  }

  public void setCarBiddings(List<CarBidding> carBiddings) {
    this.carBiddings = carBiddings;
  }

}