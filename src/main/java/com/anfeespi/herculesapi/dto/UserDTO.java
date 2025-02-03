package com.anfeespi.herculesapi.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(@Email(message = "The value must be a valid email") String email,
                      @NotBlank(message = "The username must be present and not empty") String username,
                      @NotBlank(message = "The password must be present and not empty") String password) {
}
