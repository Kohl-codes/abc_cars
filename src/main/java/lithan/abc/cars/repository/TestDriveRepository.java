package lithan.abc.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lithan.abc.cars.entity.TestDrive;

public interface TestDriveRepository extends JpaRepository<TestDrive, Integer> {

}