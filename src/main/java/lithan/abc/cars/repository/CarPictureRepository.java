package lithan.abc.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lithan.abc.cars.entity.CarPicture;

public interface CarPictureRepository extends JpaRepository<CarPicture, Integer> {

}
