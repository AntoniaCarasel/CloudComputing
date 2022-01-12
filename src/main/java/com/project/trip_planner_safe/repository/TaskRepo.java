package com.project.trip_planner_safe.repository;

import com.project.trip_planner_safe.model.Task;
import com.project.trip_planner_safe.model.Trip;
import com.project.trip_planner_safe.model.User;
import com.project.trip_planner_safe.rowmapper.AllRowMappers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class TaskRepo {
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public TaskRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Task save(Task object, Long idTrip) {
        sql = "INSERT INTO task VALUES (?,?,?,?)";
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, object.getTaskInfo());
            preparedStatement.setBoolean(3, object.isFinished());
            preparedStatement.setLong(4, idTrip);
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        Long taskId = generatedKeyHolder.getKey().longValue();
        object.setIdTask(taskId);

        return object;
    }
}
