package com.project.trip_planner_safe.mapper;

import com.project.trip_planner_safe.dto.CommentDTO;
import com.project.trip_planner_safe.dto.UserDTO;
import com.project.trip_planner_safe.model.Comment;
import com.project.trip_planner_safe.model.User;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CommentMapper {
    public Comment dtoToEntity(CommentDTO commentDTO){
        Date postDate = null;
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        try {
            postDate = sd.parse(commentDTO.getTimePosted());
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
        return new Comment(postDate, commentDTO.getTextComment());
    }

    public CommentDTO entityToDto(Comment comment){
        return new CommentDTO(comment.getTimePosted().toString(), comment.getTextComment());
    }
}
