package com.project.trip_planner_safe.mapper;

import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.model.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public Task dtoToEntity(TaskDTO taskDTO){
        return new Task(taskDTO.getTaskInfo(), taskDTO.isFinished());
    }
    public TaskDTO entityToDTO(Task task){
        return new TaskDTO(task.getTaskInfo(), task.isFinished());
    }
}
