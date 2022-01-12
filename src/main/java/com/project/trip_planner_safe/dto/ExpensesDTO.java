package com.project.trip_planner_safe.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ExpensesDTO {
    @NotBlank
    private String expenseDetails;
    @NotNull
    private double sum;

    public ExpensesDTO(String expenseDetails, double sum) {
        this.expenseDetails = expenseDetails;
        this.sum = sum;
    }

    public ExpensesDTO() {

    }
}
