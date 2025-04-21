package cs.miu.edu.cs489appsd.mapper;

import cs.miu.edu.cs489appsd.dto.request.AstronautRequestDto;
import cs.miu.edu.cs489appsd.dto.response.AstronautResponseDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.model.Astronaut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {SatelliteMapper.class})
public interface AstronautMapper {
    @Mapping(source="satellites", target="satellites")
    Astronaut astronautRequestDtoToAstronaut(AstronautRequestDto astronautRequestDto);
    @Mapping(source="satellites", target="satellites")
    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);
    @Mapping(source= "satellites", target= "satellites")
    List<AstronautResponseDto> astronautsToAstronautResponseDtos(List<Astronaut> astronauts);
}
