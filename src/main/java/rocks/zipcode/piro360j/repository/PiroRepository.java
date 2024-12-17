package rocks.zipcode.piro360j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocks.zipcode.piro360j.domain.Piro;

public interface PiroRepository extends JpaRepository<Piro, Long> {
}
