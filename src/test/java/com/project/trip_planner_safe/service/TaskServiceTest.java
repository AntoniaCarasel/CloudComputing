package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.mapper.TaskMapper;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.repository.TaskRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @InjectMocks
    private TaskService taskService;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private TaskRepo taskRepo;

    @Test
    void test_saveTask(){
        Task task = new Task();
        TaskDTO taskDTO = new TaskDTO();
        when(taskMapper.entityToDTO(task)).thenReturn(taskDTO);
        when(taskRepo.save(task, Long.valueOf(1))).thenReturn(task);

        TaskDTO result = taskService.saveTask(task, Long.valueOf(1));
        assertNotEquals(result, null);
    }
}