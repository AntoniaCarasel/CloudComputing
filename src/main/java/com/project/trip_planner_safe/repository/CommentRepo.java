package com.project.trip_planner_safe.repository;

import com.project.trip_planner_safe.model.Comment;
import com.project.trip_planner_safe.model.Event;
import com.project.trip_planner_safe.rowmapper.AllRowMappers;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class CommentRepo{
    private JdbcTemplate jdbcTemplate;
    private String sql;
    private RowMapper<Comment> mapperCreated;

    public CommentRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Comment save(Comment object, Long idTrip, Long idUser) {
        sql = "INSERT INTO comment VALUES (?,?,?,?,?)";
        Date datePosted = new java.sql.Date(object.getTimePosted().getTime());

        PreparedStatementCreator preparedStatementCreator = (connection) -> {
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setObject(1, null);
            preparedStatement.setDate(2, datePosted);
            preparedStatement.setString(3, object.getTextComment());
            preparedStatement.setLong(4, idTrip);
            preparedStatement.setLong(5, idUser);
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        Long comId = generatedKeyHolder.getKey().longValue();
        object.setIdComm(comId);

        return object;
    }

    public List<Comment> getAll(Long idTrip) {
        sql = "SELECT * FROM comment WHERE idTrip = ?";
        mapperCreated = AllRowMappers.commentMapper();

        return jdbcTemplate.query(sql, mapperCreated, idTrip);
    }
}
