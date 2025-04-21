package cs.miu.edu.cs489appsd.controller;

import cs.miu.edu.cs489appsd.dto.request.AstronautRequestDto;
import cs.miu.edu.cs489appsd.dto.response.AstronautResponseDto;
import cs.miu.edu.cs489appsd.service.AstronautService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;


    @GetMapping
    public ResponseEntity<Page<List<AstronautResponseDto>>> getAllAstronauts(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int pageSize,
            @RequestParam(defaultValue = "yearsOfExperience") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ) {
        return ResponseEntity.ok(astronautService.getAllAstronauts(page, pageSize, sortBy, sortDirection));
    }

    @GetMapping("/{astronautId}")
    public ResponseEntity<AstronautResponseDto> getAstronautById(@PathVariable Long astronautId) {
        return ResponseEntity.ok(astronautService.getAstronautById(astronautId));
    }

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(@RequestBody AstronautRequestDto astronautRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(astronautService.addNewAstronaut(astronautRequestDto));
    }

    @PutMapping("/{astronautId}")
    public ResponseEntity<AstronautResponseDto> updateAstronaut(
            @PathVariable Long astronautId,
            @RequestBody AstronautRequestDto astronautRequestDto) {
        return ResponseEntity.ok(astronautService.updateAstronaut(astronautId, astronautRequestDto));
    }
    
    
}
