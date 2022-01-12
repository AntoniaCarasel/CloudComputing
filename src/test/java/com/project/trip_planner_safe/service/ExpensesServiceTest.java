package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.ExpensesDTO;
import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.mapper.ExpensesMapper;
import com.project.trip_planner_safe.mapper.TaskMapper;
import com.project.trip_planner_safe.model.Expenses;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.repository.ExpensesRepo;
import com.project.trip_planner_safe.repository.TaskRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExpensesServiceTest {
    @InjectMocks
    private ExpensesService expensesService;

    @Mock
    private ExpensesMapper expensesMapper;

    @Mock
    private ExpensesRepo expensesRepo;

    @Test
    void test_saveExpenses(){
        Expenses expenses = new Expenses();
        ExpensesDTO expensesDTO = new ExpensesDTO();
        when(expensesMapper.entityToDto(expenses)).thenReturn(expensesDTO);
        when(expensesRepo.save(expenses, Long.valueOf(1))).thenReturn(expenses);

        ExpensesDTO result = expensesService.saveExpenses(expenses, Long.valueOf(1));
        assertNotEquals(result, null);
    }
}