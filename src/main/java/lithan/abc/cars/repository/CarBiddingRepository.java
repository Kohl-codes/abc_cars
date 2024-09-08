package lithan.abc.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import lithan.abc.cars.entity.CarBidding;

public interface CarBiddingRepository extends JpaRepository<CarBidding, Integer> {
  @Query(value = "SELECT MAX(bid_price) FROM tb_car_bid WHERE id_car = :id", nativeQuery = true)
  int highestBid(@Param("id") int id);
}