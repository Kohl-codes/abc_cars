package lithan.abc.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lithan.abc.cars.entity.ProfilePicture;

public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Integer> {

}