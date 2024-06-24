package com.riwi.workShop.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserRequest {
    @NotBlank(message = "El atributo no puede ser vacio")
    private String username;
    @NotBlank(message = "El atributo no puede ser vacio")
    private String password;
    @NotBlank(message = "El atributo no puede ser vacio")
    private String email;
    @NotBlank(message = "El atributo no puede ser vacio")
    private String fullName;
    @NotBlank(message = "El atributo no puede ser vacio")
    private String role;
}
