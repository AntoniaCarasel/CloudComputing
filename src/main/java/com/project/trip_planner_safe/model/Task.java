package com.project.trip_planner_safe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Task {
    private Long idTask;
    private String taskInfo;
    private boolean finished;

    public Task(Long idTask, String taskInfo, boolean finished) {
        this.idTask = idTask;
        this.taskInfo = taskInfo;
        this.finished = finished;
    }

    public Task(String taskInfo, boolean finished) {
        this.taskInfo = taskInfo;
        this.finished = finished;
    }

    public Task() {
    }
}
