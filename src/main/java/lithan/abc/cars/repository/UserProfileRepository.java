package lithan.abc.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lithan.abc.cars.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {

}