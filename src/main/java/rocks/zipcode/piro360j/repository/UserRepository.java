package rocks.zipcode.piro360j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocks.zipcode.piro360j.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
