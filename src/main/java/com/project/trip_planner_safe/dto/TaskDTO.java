package com.project.trip_planner_safe.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class TaskDTO {
    @NotBlank
    private String taskInfo;
    @NotNull
    private boolean finished;

    public TaskDTO(String taskInfo, boolean finished) {
        this.taskInfo = taskInfo;
        this.finished = finished;
    }

    public TaskDTO() {

    }
}
