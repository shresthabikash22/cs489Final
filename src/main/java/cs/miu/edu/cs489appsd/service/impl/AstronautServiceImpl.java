package cs.miu.edu.cs489appsd.service.impl;

import cs.miu.edu.cs489appsd.dto.request.AstronautRequestDto;
import cs.miu.edu.cs489appsd.dto.response.AstronautResponseDto;
import cs.miu.edu.cs489appsd.exception.Astronaut.AstronautNotFoundException;
import cs.miu.edu.cs489appsd.exception.Satellite.SatelliteNotFoundException;
import cs.miu.edu.cs489appsd.mapper.AstronautMapper;
import cs.miu.edu.cs489appsd.mapper.SatelliteMapper;
import cs.miu.edu.cs489appsd.model.Astronaut;
import cs.miu.edu.cs489appsd.model.Satellite;
import cs.miu.edu.cs489appsd.repository.AstronautRepository;
import cs.miu.edu.cs489appsd.repository.SatelliteRepository;
import cs.miu.edu.cs489appsd.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {
    private final AstronautRepository astronautRepository;
    private final SatelliteMapper satelliteMapper;
    private final AstronautMapper astronautMapper;
    private final SatelliteRepository satelliteRepository;

    @Override
    public Page<List<AstronautResponseDto>> getAllAstronauts(int pageNo, int pageSize, String sortBy, String sortDirection) {
        var sort = sortDirection.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();
        var pageable = PageRequest.of(pageNo, pageSize, sort);
        var astronauts = astronautRepository.findAll(pageable);
        return astronauts.map(astronaut ->
                List.of(astronautMapper.astronautToAstronautResponseDto(astronaut))
        );
    }

    @Override
    public AstronautResponseDto addNewAstronaut(AstronautRequestDto astronautRequestDto) {
        if (astronautRequestDto.satellites() != null) {
            astronautRequestDto.satellites().forEach(satelliteRequestDto -> {
                if (!satelliteRepository.findByName(satelliteRequestDto.name()).isPresent()) {
                    throw new SatelliteNotFoundException("Satellite with name " + satelliteRequestDto.name() + " not found");
                }
            });
        }
        var astronaut = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);
        var savedAstronaut = astronautRepository.save(astronaut);
        return astronautMapper.astronautToAstronautResponseDto(savedAstronaut);
    }
            
    

    @Override
    public AstronautResponseDto getAstronautById(Long astronautId) {
        Optional<Astronaut> astronaut = astronautRepository.findById(astronautId);
        if(astronaut.isPresent()){
            return astronautMapper.astronautToAstronautResponseDto(astronaut.get());
        }
        throw new AstronautNotFoundException("Astronaut with id " + astronautId + " not found");
    }

    @Override
    public AstronautResponseDto updateAstronaut(Long astronautId, AstronautRequestDto astronautRequestDto) {
        Optional<Astronaut> optionalAstronaut = astronautRepository.findById(astronautId);
        if(optionalAstronaut.isPresent()){
            Astronaut existinAstronaut = optionalAstronaut.get();
            Astronaut mappedAstronaut = astronautMapper.astronautRequestDtoToAstronaut(astronautRequestDto);
            mappedAstronaut.setId(existinAstronaut.getId());
            if(mappedAstronaut.getSatellites()!=null){
                for (Satellite mappedSatellite : mappedAstronaut.getSatellites()) {
                    for (Satellite existingSatellite : existinAstronaut.getSatellites()) {
                        if (mappedSatellite.getName().equals(existingSatellite.getName())) {
                            mappedSatellite.setId(existingSatellite.getId());
                        }
                    }
                }
                var savedAstronaut = astronautRepository.save(mappedAstronaut);
                return astronautMapper.astronautToAstronautResponseDto(savedAstronaut);
            }
        }
        throw new AstronautNotFoundException("Astronaut with id " + astronautId + " not found");
    }

    @Override
    public void deleteAstronautById(Long astronautId) {

    }
}
