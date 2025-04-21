package cs.miu.edu.cs489appsd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Table(
    name = "satellites",
        uniqueConstraints = @UniqueConstraint(columnNames = "satellite_name")
        )
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="satellite_name")
    @NotBlank
    private String name;
    private LocalDate launchDate;

    @Enumerated(EnumType.STRING)
    private OrbitType orbitType;
    private boolean decommissioned;

    public enum OrbitType {
        LEO,
        MEO,
        GEO
    }
    @ManyToMany(mappedBy = "satellites")
    List<Astronaut> astronauts;


}
