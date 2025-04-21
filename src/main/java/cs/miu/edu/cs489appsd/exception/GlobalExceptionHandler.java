package cs.miu.edu.cs489appsd.exception;

import cs.miu.edu.cs489appsd.exception.Astronaut.AstronautNotFoundException;
import cs.miu.edu.cs489appsd.exception.Astronaut.DuplicateAstronautException;
import cs.miu.edu.cs489appsd.exception.Satellite.SatelliteNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateAstronautException.class)
    public ResponseEntity<ApiError> handleDuplicateAstronautException(DuplicateAstronautException ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrityViolationException(DataIntegrityViolationException ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.CONFLICT.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(","));
        ApiError apiError = new ApiError(
                errorMessage,
                request.getRequestURI(),
                HttpStatus.BAD_REQUEST.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }

    @ExceptionHandler(AstronautNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(AstronautNotFoundException ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(SatelliteNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFoundException(SatelliteNotFoundException ex, HttpServletRequest request) {
        ApiError apiError = new ApiError(
                ex.getMessage(),
                request.getRequestURI(),
                HttpStatus.NOT_FOUND.value(),
                Instant.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

}
