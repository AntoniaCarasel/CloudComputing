package com.project.trip_planner_safe.repository;

import java.util.List;
import java.util.Optional;

public interface Repo<O> {
    List<O> getAll();
    Optional<O> getObject(Long id);
    boolean delete(Long id);
}

