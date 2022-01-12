package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.EventDTO;
import com.project.trip_planner_safe.mapper.EventMapper;
import com.project.trip_planner_safe.model.Event;
import com.project.trip_planner_safe.model.User;
import com.project.trip_planner_safe.repository.EventRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    private EventRepo eventRepo;
    private EventMapper eventMapper;

    public EventService(EventRepo eventRepo, EventMapper eventMapper) {
        this.eventRepo = eventRepo;
        this.eventMapper = eventMapper;
    }

    public EventDTO saveEvent(Event object, Long id){
        Event eventSaved= eventRepo.save(object, id);
        EventDTO event = eventMapper.entityToDto(eventSaved);
        return event;
    }

    public List<Event> getAllEvents(Long idTrip){
        return eventRepo.getAll(idTrip);
    }
}
