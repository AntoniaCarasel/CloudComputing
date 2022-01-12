package com.project.trip_planner_safe.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter
@Setter
public class CommentDTO {
    @NotNull
    private String timePosted;
    @NotBlank
    private String textComment;

    public CommentDTO(String timePosted, String textComment) {
        this.timePosted = timePosted;
        this.textComment = textComment;
    }
}
