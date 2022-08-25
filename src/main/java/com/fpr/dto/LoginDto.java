package com.fpr.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginDto {

    @Email
    @NotNull
    private String email;

    @NotNull
    private String password;

}
