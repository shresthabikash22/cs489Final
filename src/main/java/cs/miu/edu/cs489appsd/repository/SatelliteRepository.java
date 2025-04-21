package cs.miu.edu.cs489appsd.repository;

import cs.miu.edu.cs489appsd.model.Satellite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SatelliteRepository extends JpaRepository<Satellite, Long> {

    Optional<Satellite> findByName(String name);
}
