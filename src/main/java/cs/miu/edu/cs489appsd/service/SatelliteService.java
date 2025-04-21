package cs.miu.edu.cs489appsd.service;

import cs.miu.edu.cs489appsd.dto.request.SatelliteRequestDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.model.Satellite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SatelliteService {
    List<SatelliteResponseDto> getAllSatellites();

    SatelliteResponseDto getSatelliteById(Long id);

    SatelliteResponseDto createSatellite(SatelliteRequestDto satellite);

    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto satellite);

    void deleteSatellite(Long id);
}
