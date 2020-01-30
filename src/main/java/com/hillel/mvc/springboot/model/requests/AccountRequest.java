package com.hillel.mvc.springboot.model.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRequest {
    private int id;

    private float amount;

    @NotEmpty(message = "Creation date must be set.")
    @Pattern(regexp = "([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))", message = "Incorrect date format.")
    private String creationDate;

    @Range(min = 0, message = "User id can't be less than 0.")
    private int userId;
}
