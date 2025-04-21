package cs.miu.edu.cs489appsd.mapper;

import cs.miu.edu.cs489appsd.dto.request.SatelliteRequestDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.model.Satellite;
import org.mapstruct.Mapper;

import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {

    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);

    Satellite satelliteRequestDtoToSatellite (SatelliteRequestDto satelliteResponseDto);

    List<SatelliteResponseDto> satellitesToSatelliteResponseDtos(List<Satellite> satellites);
}
