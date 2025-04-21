package cs.miu.edu.cs489appsd.service.impl;

import cs.miu.edu.cs489appsd.dto.request.SatelliteRequestDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.exception.Satellite.SatelliteNotFoundException;
import cs.miu.edu.cs489appsd.mapper.SatelliteMapper;
import cs.miu.edu.cs489appsd.model.Satellite;
import cs.miu.edu.cs489appsd.repository.SatelliteRepository;
import cs.miu.edu.cs489appsd.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {
    private final SatelliteRepository satelliteRepository;
    private final SatelliteMapper satelliteMapper;



    @Override
    public List<SatelliteResponseDto> getAllSatellites() {
        List<Satellite> satellites = satelliteRepository.findAll();
        return satelliteMapper.satellitesToSatelliteResponseDtos(satellites);
    }

    @Override
    public SatelliteResponseDto getSatelliteById(Long id) {
        Satellite satellite = satelliteRepository.findById(id).orElseThrow(() -> new SatelliteNotFoundException("Satellite with id " + id + " not found"));
        return satelliteMapper.satelliteToSatelliteResponseDto(satellite);
    }

    @Override
    public SatelliteResponseDto createSatellite(SatelliteRequestDto satelliteRequestDto) {
        Satellite satellite = satelliteMapper.satelliteRequestDtoToSatellite(satelliteRequestDto);
        Satellite savedSatellite = satelliteRepository.save(satellite);
        return satelliteMapper.satelliteToSatelliteResponseDto(savedSatellite);
    }

    @Override
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto satellite) {
        if(satelliteRepository.existsById(id)) {
            Satellite satellite1 = satelliteMapper.satelliteRequestDtoToSatellite(satellite);
            Satellite savedSatellite = satelliteRepository.save(satellite1);
            return satelliteMapper.satelliteToSatelliteResponseDto(savedSatellite);
        }
      throw new SatelliteNotFoundException(satellite.name() + " not found");

    }

    @Override
    public void deleteSatellite(Long id) {

    }
}
