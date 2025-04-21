package cs.miu.edu.cs489appsd.controller;

import cs.miu.edu.cs489appsd.dto.request.SatelliteRequestDto;
import cs.miu.edu.cs489appsd.dto.response.SatelliteResponseDto;
import cs.miu.edu.cs489appsd.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {
    private final SatelliteService satelliteService;

    @GetMapping
    public ResponseEntity<List<SatelliteResponseDto>> getAllSatellites(

    ) {
        List<SatelliteResponseDto> satelliteResponseDtos = satelliteService.getAllSatellites();
        return ResponseEntity.status(HttpStatus.OK).body(satelliteResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> getSatelliteById(@PathVariable Long id) {
        SatelliteResponseDto satelliteResponseDto = satelliteService.getSatelliteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(satelliteResponseDto);
    }

    @PostMapping
    public ResponseEntity<SatelliteResponseDto> createSatellite(@RequestBody SatelliteRequestDto satellite) {
        SatelliteResponseDto satelliteResponseDto = satelliteService.createSatellite(satellite);
        return ResponseEntity.status(HttpStatus.CREATED).body(satelliteResponseDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(@PathVariable Long id, @RequestBody SatelliteRequestDto satellite) {
        SatelliteResponseDto satelliteResponseDto = satelliteService.updateSatellite(id, satellite);
        return ResponseEntity.status(HttpStatus.OK).body(satelliteResponseDto);
    }


    
    
}
