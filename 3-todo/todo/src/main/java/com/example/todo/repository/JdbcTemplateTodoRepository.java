package com.example.todo.repository;

import com.example.todo.entity.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class JdbcTemplateTodoRepository implements TodoRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertActor;
    public JdbcTemplateTodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("todo")
                .usingGeneratedKeyColumns("id")
                .usingColumns("content","author_name","password");
    }

    @Override
    public Long saveAndReturnKey(Todo todo) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("content",todo.getContent());
        parameters.put("author_name",todo.getAuthorName());
        parameters.put("password",todo.getPassword());

        Number key = insertActor.executeAndReturnKey(parameters);

        return key.longValue();
    }

    @Override
    public List<Todo> findAllByUpdatedAtAndAuthorName(LocalDate updateAt, String authorName) {
        StringBuilder sql = new StringBuilder("select * from todo ");
        if(updateAt==null && authorName==null) {
            return jdbcTemplate.query(sql.toString(),todoRowMapper());
        }

        sql.append("where ");
        boolean andFlag = false;
        List<Object> params = new ArrayList<>();
        if(updateAt!=null) {
            sql.append("DATE(updated_at) = ? ");
            params.add(Date.valueOf(updateAt));
            andFlag = true;
        }
        if(authorName!=null && !authorName.isEmpty()) {
            if(andFlag) {
                sql.append("and ");
            }
            sql.append("author_name = ? ");
            params.add(authorName);
        }
        log.info("sql : {}",sql);
        log.info("params = {}",params);
        return jdbcTemplate.query(sql.toString(), todoRowMapper(), params.toArray());
    }

    private RowMapper<Todo> todoRowMapper() {
        return new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Todo.builder()
                        .id(rs.getLong("id"))
                        .authorName(rs.getString("author_name"))
                        .content(rs.getString("content"))
                        .password(rs.getString("password"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();
            }
        };
    }
}
