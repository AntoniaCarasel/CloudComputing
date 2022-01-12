package com.project.trip_planner_safe.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.trip_planner_safe.dto.TripDTO;
import com.project.trip_planner_safe.mapper.EventMapper;
import com.project.trip_planner_safe.mapper.TripMapper;
import com.project.trip_planner_safe.model.Country;
import com.project.trip_planner_safe.model.Trip;
import com.project.trip_planner_safe.service.EventService;
import com.project.trip_planner_safe.service.TripService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class TripControllerTest {
    @InjectMocks
    private TripController tripController;

    @Mock
    private TripService tripService;

    @Mock
    private TripMapper tripMapper;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

//    @Test
//    public void test_getTrip() throws Exception{
//        Trip trip = new Trip();
//        TripDTO tripDto = new TripDTO("BarcelonaEscape", "A nice trip to the city of dancing", Country.Spain, "14-01-2021", "18-01-2021");
//        Long idTrip = 1L;
//        when(tripService.getTrip(idTrip)).thenReturn(trip);
//        when(tripMapper.entityToDto(trip)).thenReturn(tripDto);
//
//        TripDTO result = tripMapper.entityToDto(tripService.getTrip(idTrip));
//
//
//        assertEquals(result.toString(), objectMapper.writeValueAsString(tripDto));
//    }
}