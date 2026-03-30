package com.nilsson.api_wigell_travel.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AddressCreateDto (
        @NotBlank @Size(max = 30) String streetAddress,
        @NotBlank @Size(max = 60) String city,
        @NotBlank @Size(max = 10) @Pattern(regexp = "[0-9\\s]+$") String postalCode
){
}
