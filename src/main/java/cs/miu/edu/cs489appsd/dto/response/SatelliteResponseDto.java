package cs.miu.edu.cs489appsd.dto.response;

import java.time.LocalDate;

public record SatelliteResponseDto(
        Long id,
        String name,
        LocalDate launchDate
) {
}
