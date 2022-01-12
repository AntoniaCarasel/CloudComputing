package com.project.trip_planner_safe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Expenses {
    private Long idExp;
    private String expenseDetails;
    private double sum;

    public Expenses(Long idExp, String expenseDetails, double sum) {
        this.idExp = idExp;
        this.expenseDetails = expenseDetails;
        this.sum = sum;
    }

    public Expenses(String expenseDetails, double sum) {
        this.expenseDetails = expenseDetails;
        this.sum = sum;
    }

    public Expenses() {

    }
}
