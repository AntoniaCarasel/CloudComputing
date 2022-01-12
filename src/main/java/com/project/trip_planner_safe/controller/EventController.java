package com.project.trip_planner_safe.controller;

import com.project.trip_planner_safe.dto.EventDTO;
import com.project.trip_planner_safe.dto.TripDTO;
import com.project.trip_planner_safe.mapper.EventMapper;
import com.project.trip_planner_safe.model.Event;
import com.project.trip_planner_safe.model.Trip;
import com.project.trip_planner_safe.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/trip/{idTrip}/events")
public class EventController {
    private EventService eventService;
    private EventMapper eventMapper;

    public EventController(EventService eventService, EventMapper eventMapper) {
        this.eventService = eventService;
        this.eventMapper = eventMapper;
    }

    @PostMapping
    public ResponseEntity<EventDTO> createEvent(@Valid @RequestBody EventDTO eventRequest, @PathVariable("idTrip") Long idTrip){
        Event eventHelp = eventMapper.dtoToEntity(eventRequest);
        EventDTO eventDTO = eventService.saveEvent(eventHelp, idTrip);
        return ResponseEntity
                .ok()
                .body(eventDTO);
    }

    @GetMapping
    public List<EventDTO> getAllEvents(@PathVariable("idTrip") Long idTrip){
        List<Event> eventList = eventService.getAllEvents(idTrip);
        List<EventDTO> eventsDTOlist = new ArrayList<>();
        for(Event event:eventList){
            eventsDTOlist.add(eventMapper.entityToDto(event));
        }
        return eventsDTOlist;
    }

}
