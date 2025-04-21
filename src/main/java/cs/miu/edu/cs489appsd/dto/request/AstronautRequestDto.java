package cs.miu.edu.cs489appsd.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public record AstronautRequestDto(
        @NotBlank(message = "firstname cannot be blank/empty/null")
        @Size(min = 2, max = 20,message = "firstname must be between 2 and 20 characters")
        String firstName,
        @NotBlank(message = "lastname cannot be blank/empty/null")
        @Size(min = 2, max = 20, message = "lastname must be between 2 and 20 characters")
        String lastName,
        @Min(0) @Max(50)
        int yearsOfExperience,
        @Valid
        List<SatelliteRequestDto> satellites
) {
}
