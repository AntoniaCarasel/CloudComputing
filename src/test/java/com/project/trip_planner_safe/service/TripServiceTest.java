package com.project.trip_planner_safe.service;

import com.project.trip_planner_safe.dto.TaskDTO;
import com.project.trip_planner_safe.dto.TripDTO;
import com.project.trip_planner_safe.mapper.TaskMapper;
import com.project.trip_planner_safe.mapper.TripMapper;
import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.model.Trip;
import com.project.trip_planner_safe.model.User;
import com.project.trip_planner_safe.repository.TaskRepo;
import com.project.trip_planner_safe.repository.TripRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TripServiceTest {
    @InjectMocks
    private TripService tripService;

    @Mock
    private TripMapper tripMapper;

    @Mock
    private TripRepo tripRepo;

    @Test
    void test_addUserToTrip(){
        User user = new User();
        when(tripRepo.addUserToTrip(1L, 3L)).thenReturn(user);

        User result = tripRepo.addUserToTrip(1L, 3L);
        assertNotEquals(result, null);
    }
}