package com.project.trip_planner_safe.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id) {
       super("User with id " + id + " doesn't exist ");
    }
}
