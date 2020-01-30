package com.hillel.mvc.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private int id;
    private Float amount;
    private int userId;
    private User user;
    private LocalDate creationDate;
}
