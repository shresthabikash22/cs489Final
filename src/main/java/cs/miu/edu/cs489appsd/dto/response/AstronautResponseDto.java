package cs.miu.edu.cs489appsd.dto.response;

import java.util.List;

public record AstronautResponseDto(
        String firstName,
        String lastName,
        int yearsOfExperience,
        List<SatelliteResponseDto> satellites
) {
}
