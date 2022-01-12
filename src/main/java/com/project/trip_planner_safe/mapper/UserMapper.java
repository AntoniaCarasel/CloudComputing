package com.project.trip_planner_safe.mapper;

import com.project.trip_planner_safe.dto.UserCleanDTO;
import com.project.trip_planner_safe.dto.UserDTO;
import com.project.trip_planner_safe.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User dtoToEntity(UserDTO userDTO){
        return new User(userDTO.getName(), userDTO.getSurname(), userDTO.getEmail(), userDTO.getDescription(), userDTO.getPassword(), userDTO.getAge());
    }

    public UserCleanDTO entityToDto(User user){
        return new UserCleanDTO(user.getName(), user.getSurname(), user.getEmail(), user.getDescription(),user.getAge());
    }

}
