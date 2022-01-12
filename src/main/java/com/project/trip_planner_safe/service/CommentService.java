package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.CommentDTO;
import com.project.trip_planner_safe.model.Comment;
import com.project.trip_planner_safe.model.Event;
import com.project.trip_planner_safe.repository.CommentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private CommentRepo commentRepo;

    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }

    public CommentDTO saveComment(Comment object, Long idTrip, Long idUser) {
        Comment commentSaved = commentRepo.save(object, idTrip, idUser);
        CommentDTO comment = new CommentDTO(commentSaved.getTimePosted().toString(), commentSaved.getTextComment());
        return comment;
    }

    public List<Comment> getAllComments(Long idTrip){
        return commentRepo.getAll(idTrip);
    }
}
