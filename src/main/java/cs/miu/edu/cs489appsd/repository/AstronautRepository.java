package cs.miu.edu.cs489appsd.repository;

import cs.miu.edu.cs489appsd.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
    Optional<Astronaut> findByFirstName(String name);
}
