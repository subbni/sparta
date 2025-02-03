package com.example.todo.todo.repository;

import com.example.todo.todo.dto.TodoDetail;
import com.example.todo.todo.dto.TodoUpdateRequest;
import com.example.todo.todo.domain.Todo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

@Slf4j
@Repository
public class JdbcTemplateTodoRepository implements TodoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertActor;
    public JdbcTemplateTodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("todos")
                .usingGeneratedKeyColumns("id")
                .usingColumns("content","user_id","password");
    }

    @Override
    public Long saveAndReturnKey(Todo todo) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("content",todo.getContent());
        parameters.put("user_id",todo.getUserId());
        parameters.put("password",todo.getPassword());

        Number key = insertActor.executeAndReturnKey(parameters);

        return key.longValue();
    }

    @Override
    public Optional<TodoDetail> findById(Long id) {
        String sql = "select * from todos join users u on todos.user_id = u.id where todos.id = ?";
        List<TodoDetail> result = jdbcTemplate.query(
                sql,
                todoDatailRowMapper(),
                id);
        return result.stream().findAny();
    }

    @Override
    public List<TodoDetail> findAll() {
        String sql = "select * from todos join users u on todos.user_id = u.id";
        return jdbcTemplate.query(sql, todoDatailRowMapper());
    }

     @Override
     public List<TodoDetail> findAllByUserIdAndUpdatedAt(Long userId, LocalDate updatedAt) {
         StringBuilder sql = new StringBuilder("select * from todos join users u on todos.user_id = u.id ");
         if(userId == null && updatedAt == null) {
         sql.append("order by todos.updated_at desc");
         return jdbcTemplate.query(sql.toString(),todoDatailRowMapper());
         }

         sql.append("where ");
         boolean andFlag = false;
         List<Object> params = new ArrayList<>();
         if(userId!=null) {
             sql.append("user_id = ? ");
             params.add(userId);
             andFlag = true;
         }
         if(updatedAt!=null) {
             if(andFlag) {
                 sql.append("and ");
             }
             sql.append("DATE(todos.updated_at) = ? ");
             params.add(java.sql.Date.valueOf(updatedAt));
         }

         sql.append("order by todos.updated_at desc");

         log.info("sql : {}",sql);
         log.info("params = {}",params);
         return jdbcTemplate.query(sql.toString(), todoDatailRowMapper(), params.toArray());
     }

    @Override
    public void update(TodoUpdateRequest updateRequest) {
        String sql = "update todos set content = ? where id = ?";
        jdbcTemplate.update(sql,
                updateRequest.getContent(),
                updateRequest.getTodoId());
    }

    @Override
    public void updateContent(Long id, String content) {
        String sql = "update todos set content = ? where id = ?";
        jdbcTemplate.update(sql,
                id,
                content);
    }

    public void delete(Long id) {
        String sql = "delete from todos where id = ?";
        jdbcTemplate.update(sql, id);
    }

    private RowMapper<Todo> todoRowMapper() {
        return new RowMapper<Todo>() {
            @Override
            public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Todo.builder()
                        .id(rs.getLong("id"))
                        .content(rs.getString("content"))
                        .password(rs.getString("password"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();
            }
        };
    }

    private RowMapper<TodoDetail> todoDatailRowMapper() {
        return new RowMapper<TodoDetail>() {
            @Override
            public TodoDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
                return TodoDetail.builder()
                        .id(rs.getLong("id"))
                        .content(rs.getString("content"))
                        .password((rs.getString("password")))
                        .userId(rs.getLong("u.id"))
                        .userName(rs.getString("u.name"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();
            }
        };
    }
}
