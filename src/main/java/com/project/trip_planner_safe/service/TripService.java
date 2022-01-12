package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.TripDTO;
import com.project.trip_planner_safe.exceptions.UserNotFoundException;
import com.project.trip_planner_safe.mapper.TripMapper;
import com.project.trip_planner_safe.model.Trip;
import com.project.trip_planner_safe.model.User;
import com.project.trip_planner_safe.repository.TripRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    private TripRepo tripRepo;
    private TripMapper tripMapper;

    public TripService(TripRepo tripRepo) {
        this.tripRepo = tripRepo;
    }

    public TripDTO saveTrip(Trip object, Long id) {
        Trip tripSaved = tripRepo.save(object, id);
        TripDTO trip = new TripDTO(tripSaved.getTripName(), tripSaved.getDescription(), tripSaved.getCountryName(), tripSaved.getStartDate().toString(), tripSaved.getEndDate().toString());
        return trip;
    }

    public User addUserToTrip(Long idTrip, Long idUser){
        return tripRepo.addUserToTrip(idTrip, idUser);
    }

    public Trip getTrip(Long id) {
        Optional<Trip> tripFound = tripRepo.getObject(id);
        if(tripFound.isPresent()){
            return tripFound.get();
        }
        throw new UserNotFoundException(id);
    }

    public List<Trip> getTrip_name(String name) {
        return null;
    }

    public List<Trip> getAllTrips() {
        return tripRepo.getAll();
    }

    public boolean deleteTrip(Long id) {
        return tripRepo.delete(id);
    }

    public List<User> getParticipants(Long idTrip){
        return tripRepo.getParticipants(idTrip);
    }
}
