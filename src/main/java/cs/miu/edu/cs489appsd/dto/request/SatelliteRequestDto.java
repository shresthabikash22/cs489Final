package cs.miu.edu.cs489appsd.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record SatelliteRequestDto(
        @NotBlank(message = "Satellite name cannot be blank/empty/null")
        String name,
        LocalDate launchDate,
        String orbitType
) {
}
