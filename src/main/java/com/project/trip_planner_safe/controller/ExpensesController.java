package com.project.trip_planner_safe.controller;

import com.project.trip_planner_safe.dto.ExpensesDTO;
import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.mapper.ExpensesMapper;
import com.project.trip_planner_safe.model.Expenses;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.service.ExpensesService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/trip/{idTrip}/expenses")
public class ExpensesController {
    private ExpensesMapper expensesMapper;
    private ExpensesService expensesService;

    public ExpensesController(ExpensesMapper expensesMapper, ExpensesService expensesService) {
        this.expensesMapper = expensesMapper;
        this.expensesService = expensesService;
    }

    @PostMapping()
    public ExpensesDTO saveTask(@Valid @RequestBody ExpensesDTO expensesRequest, @PathVariable("idTrip") Long idTrip){
        Expenses expensesHelp = expensesMapper.dtoToEntity(expensesRequest);
        ExpensesDTO expensesDTO = expensesService.saveExpenses(expensesHelp, idTrip);
        return expensesDTO;
    }
}
