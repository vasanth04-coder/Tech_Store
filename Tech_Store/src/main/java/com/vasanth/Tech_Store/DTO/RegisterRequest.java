package com.vasanth.Tech_Store.DTO;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RegisterRequest
{
    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 8,max = 15)
    private String password;

    @Email
    private String email;

}
