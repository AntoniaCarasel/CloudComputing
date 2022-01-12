package com.project.trip_planner_safe.repository;

import com.project.trip_planner_safe.model.Expenses;
import com.project.trip_planner_safe.model.Task;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class ExpensesRepo{
    private JdbcTemplate jdbcTemplate;
    private String sql;

    public ExpensesRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Expenses save(Expenses object, Long idTrip) {
        sql = "INSERT INTO expenses VALUES (?,?,?,?)";
        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setString(2, object.getExpenseDetails());
            preparedStatement.setDouble(3, object.getSum());
            preparedStatement.setLong(4, idTrip);
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        Long expensesId = generatedKeyHolder.getKey().longValue();
        object.setIdExp(expensesId);

        return object;
    }
}
