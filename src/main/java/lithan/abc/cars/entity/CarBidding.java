package lithan.abc.cars.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

@Entity
@Table(name = "tb_car_bid")
public class CarBidding {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_bid")
  private int idBid;

  @Digits(integer = 10, fraction = 2)
  @Column(nullable = false)
  private int bidPrice;

  private String status;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user")
  private UserAccount user;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "id_car")
  private Car car;

  public CarBidding() {
  }

  public int getIdBid() {
    return idBid;
  }

  public void setIdBid(int idBid) {
    this.idBid = idBid;
  }

  public int getBidPrice() {
    return bidPrice;
  }

  public void setBidPrice(int bidPrice) {
    this.bidPrice = bidPrice;
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

  public Car getCar() {
    return car;
  }

  public void setCar(Car car) {
    this.car = car;
  }

}
