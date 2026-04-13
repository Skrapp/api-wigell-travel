package com.nilsson.api_wigell_travel.exception;

import com.nilsson.api_wigell_travel.logging.LoggingAspectControllers;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationError(MethodArgumentNotValidException e, HttpServletRequest request){

        logger.warn("Validation error caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getFieldErrors().forEach(err ->
                errors.put(err.getField(), err.getDefaultMessage()));

        Map<String, Object> response = buildResponse(
                HttpStatus.BAD_REQUEST,
                "Invalid input data",
                e.getMessage());
        response.put("affected fields", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerNotFound(CustomerNotFoundException e, HttpServletRequest request){

        logger.warn("Customer not found caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, Object> response = buildResponse(
                HttpStatus.NOT_FOUND,
                "Not found",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleBookingNotFound(BookingNotFoundException e, HttpServletRequest request){

        logger.warn("Booking not found caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, Object> response = buildResponse(
                HttpStatus.NOT_FOUND,
                "Not found",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AddressAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleAddressAlreadyExists(AddressAlreadyExistsException e, HttpServletRequest request){

        logger.warn("Address already exists caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, Object> response = buildResponse(
                HttpStatus.NOT_FOUND,
                "Not found",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DestinationNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleDestinationNotFound(DestinationNotFoundException e, HttpServletRequest request){

        logger.warn("Destination not found caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, Object> response = buildResponse(
                HttpStatus.NOT_FOUND,
                "Not found",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(AuthorizationDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDenied(AuthorizationDeniedException e, HttpServletRequest request){
        Map<String, Object> response = buildResponse(
                HttpStatus.FORBIDDEN,
                "Forbidden access",
                e.getMessage() + ": You do not have the right authorization to reach this data");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> handleIllegalArgument(IllegalArgumentException e, HttpServletRequest request){

        logger.warn("Illegal argument caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, Object> response = buildResponse(
                HttpStatus.BAD_REQUEST,
                "Bad request",
                e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneral(Exception e, HttpServletRequest request){

        logger.error("Exception caught in [{} - {}]: {}",
                request.getMethod(), request.getRequestURI(), e.getMessage(),e);

        Map<String, Object> response = buildResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal server error, contact support",
                e.getMessage());


        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    //TODO make ResponseEntity
    private static Map<String, Object> buildResponse(HttpStatus internalServerError, String value, String message) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("timestamp", LocalDateTime.now().toString());
        response.put("status", internalServerError.value());
        response.put("error", value);
        response.put("message", message);
        return response;
    }
}
