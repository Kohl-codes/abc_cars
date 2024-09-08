package lithan.abc.cars.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import lithan.abc.cars.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

  public Role findByRole(String role);
}