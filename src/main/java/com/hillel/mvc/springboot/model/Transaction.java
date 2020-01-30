package com.hillel.mvc.springboot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Transaction {
    private LocalDate transactionDate;
    private Account sender;
    private Account receiver;
    float amount;
    boolean isSuccessful;
}