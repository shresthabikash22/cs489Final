package cs.miu.edu.cs489appsd.mapper;

import cs.miu.edu.cs489appsd.dto.request.SatelliteRequestDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SatelliteMapper {

    @Mapping(source="satellite_name", target="name")
    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);

    @Mapping(source="name", target="satellite_name")
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto satelliteRequestDto);

    @Mapping(source="satellite_name", target="name")
    List<SatelliteResponseDto> satellitesToSatelliteResponseDtos(List<Satellite> satellites);

    @Mapping(source="name", target="satellite_name")
    Satellite satelliteResponseDtoToSatellite(SatelliteResponseDto satelliteResponseDto);
}