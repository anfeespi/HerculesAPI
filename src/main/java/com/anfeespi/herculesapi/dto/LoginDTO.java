package com.anfeespi.herculesapi.dto;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(@NotBlank(message = "Must enter a username") String username,
                       @NotBlank(message = "Must enter a password")  String password) {
}
