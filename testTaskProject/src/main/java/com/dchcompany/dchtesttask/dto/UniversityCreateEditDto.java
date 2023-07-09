package com.dchcompany.dchtesttask.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;

@Value
public class UniversityCreateEditDto {
@Size(min=3,max = 20)
    private String name;
    @Size(min=3,max = 20)
    private String address;
    @Email
    private String email;
    private String phone;
}
