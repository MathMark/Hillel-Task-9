package com.hillel.mvc.springboot.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
    private int id;

    @NotEmpty(message = "Last name is required.")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Incorrect name.")
    private String lastName;

    @NotEmpty(message = "First name is required.")
    @Pattern(regexp = "[A-Z][a-z]+", message = "Incorrect name.")
    private String firstName;

    @NotEmpty(message = "Birth date is required.")
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))", message = "Incorrect date format.")
    private String birthDate;

    @NotNull(message = "Gender must be selected.")
    private String gender;
}
