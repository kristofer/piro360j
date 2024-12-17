package rocks.zipcode.piro360j.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rocks.zipcode.piro360j.domain.Tag;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
