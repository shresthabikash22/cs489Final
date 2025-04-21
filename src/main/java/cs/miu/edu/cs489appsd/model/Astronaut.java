package cs.miu.edu.cs489appsd.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Table(name = "astronauts")
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 2, max = 20)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 20)
    private String lastName;
    @Min(0) @Max(50)
    private int yearsOfExperience;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "astronaut_satellite",
            joinColumns = @JoinColumn(name="astronaut_id"),
            inverseJoinColumns = @JoinColumn(name = "satellite_id")
    )
    List<Satellite> satellites;
}
