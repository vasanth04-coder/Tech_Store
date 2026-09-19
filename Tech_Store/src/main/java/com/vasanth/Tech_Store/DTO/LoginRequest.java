package com.vasanth.Tech_Store.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class LoginRequest
{
    @Email
    private  String email;

    @NotBlank
    @Size(min =8,max = 12)
    private String password;
}

