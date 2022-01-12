package com.project.trip_planner_safe.controller;

import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.dto.TripDTO;
import com.project.trip_planner_safe.mapper.TaskMapper;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.model.Trip;
import com.project.trip_planner_safe.service.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/trip/{idTrip}/tasks")
public class TaskController {
    private TaskService taskService;
    private TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping()
    public TaskDTO saveTask(@Valid @RequestBody TaskDTO taskRequest, @PathVariable("idTrip") Long idTrip){
        Task taskHelp = taskMapper.dtoToEntity(taskRequest);
        TaskDTO taskDTO = taskService.saveTask(taskHelp, idTrip);
        return taskDTO;
    }

}
