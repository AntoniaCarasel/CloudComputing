package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.dto.TripDTO;
import com.project.trip_planner_safe.mapper.TaskMapper;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.repository.TaskRepo;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private TaskRepo taskRepo;
    private TaskMapper taskMapper;

    public TaskService(TaskRepo taskRepo, TaskMapper taskMapper) {
        this.taskRepo = taskRepo;
        this.taskMapper = taskMapper;
    }

    public TaskDTO saveTask(Task object, Long idTrip){
        Task taskSaved = taskRepo.save(object, idTrip);
        TaskDTO task = taskMapper.entityToDTO(taskSaved);
        return task;
    }
}
