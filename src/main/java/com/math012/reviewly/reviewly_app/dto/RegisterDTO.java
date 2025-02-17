package com.math012.reviewly.reviewly_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterDTO {
    private String name;
    private String lastname;
    private Integer age;
    private String username;
    private String password;
}
