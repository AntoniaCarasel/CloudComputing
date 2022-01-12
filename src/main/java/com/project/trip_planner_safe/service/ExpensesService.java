package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.ExpensesDTO;
import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.mapper.ExpensesMapper;
import com.project.trip_planner_safe.model.Expenses;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.repository.ExpensesRepo;
import org.springframework.stereotype.Service;

@Service
public class ExpensesService {
    private ExpensesRepo expensesRepo;
    private ExpensesMapper expensesMapper;

    public ExpensesService(ExpensesRepo expensesRepo, ExpensesMapper expensesMapper) {
        this.expensesRepo = expensesRepo;
        this.expensesMapper = expensesMapper;
    }

    public ExpensesDTO saveExpenses(Expenses object, Long idTrip){
        Expenses expensesSaved = expensesRepo.save(object, idTrip);
        ExpensesDTO expenses = expensesMapper.entityToDto(expensesSaved);
        return expenses;
    }
}
