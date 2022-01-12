package com.project.trip_planner_safe.controller;

import com.project.trip_planner_safe.dto.CommentDTO;
import com.project.trip_planner_safe.dto.EventDTO;
import com.project.trip_planner_safe.mapper.CommentMapper;
import com.project.trip_planner_safe.model.Comment;
import com.project.trip_planner_safe.model.Event;
import com.project.trip_planner_safe.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trip/{idTrip}")
public class CommentController {
    private CommentService commentService;
    private CommentMapper commentMapper;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }



    @PostMapping("/{idUser}")
    private CommentDTO saveComment(@Valid @RequestBody CommentDTO commentRequest, @PathVariable("idTrip") Long idTrip, @PathVariable("idUser") Long idUser){
        Comment commentHelp = commentMapper.dtoToEntity(commentRequest);
        CommentDTO commentDTO = commentService.saveComment(commentHelp, idTrip, idUser);
        return commentDTO;
    }

    @GetMapping
    public List<CommentDTO> getAllComments(@PathVariable("idTrip") Long idTrip){
        List<Comment> commentsList = commentService.getAllComments(idTrip);
        List<CommentDTO> commentsDTOlist = new ArrayList<>();
        for(Comment comment:commentsList){
            commentsDTOlist.add(commentMapper.entityToDto(comment));
        }
        return commentsDTOlist;
    }

}
