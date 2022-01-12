package com.project.trip_planner_safe.mapper;

import com.project.trip_planner_safe.dto.ExpensesDTO;
import com.project.trip_planner_safe.model.Expenses;
import org.springframework.stereotype.Component;

@Component
public class ExpensesMapper {
    public Expenses dtoToEntity(ExpensesDTO expensesDTO){
        return new Expenses(expensesDTO.getExpenseDetails(), expensesDTO.getSum());
    }

    public ExpensesDTO entityToDto(Expenses expenses){
        return new ExpensesDTO(expenses.getExpenseDetails(), expenses.getSum());
    }
}
