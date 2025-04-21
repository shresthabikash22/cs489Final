package cs.miu.edu.cs489appsd.service;

import cs.miu.edu.cs489appsd.dto.request.AstronautRequestDto;
import cs.miu.edu.cs489appsd.dto.request.SatelliteRequestDto;
import cs.miu.edu.cs489appsd.dto.response.AstronautResponseDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.model.Astronaut;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AstronautService {
    Page<List<AstronautResponseDto>> getAllAstronauts(int pageNo, int pageSize, String sortBy, String sortDirection);

    AstronautResponseDto addNewAstronaut(AstronautRequestDto astronautRequestDto);

    AstronautResponseDto getAstronautById(Long astronautId);

    AstronautResponseDto updateAstronaut(Long astronautId, AstronautRequestDto astronautRequestDto);

    void deleteAstronautById(Long astronautId);


}
