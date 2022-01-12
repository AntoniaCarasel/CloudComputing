package com.project.trip_planner_safe.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Comment {
    private Long idComm;
    private Date timePosted;
    private String textComment;

    public Comment(Long idComm, Date timePosted, String textComment) {
        this.idComm = idComm;
        this.timePosted = timePosted;
        this.textComment = textComment;
    }

    public Comment(Date timePosted, String textComment) {
        this.timePosted = timePosted;
        this.textComment = textComment;
    }
}
