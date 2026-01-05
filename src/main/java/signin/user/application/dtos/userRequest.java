package signin.user.application.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record userRequest(
        @NotBlank(message = "name cannot be blank") String name
        , @NotBlank(message = "password cannot be blank") String password,
        @NotBlank(message = "email cannot be blank") @Email String email
) {}
