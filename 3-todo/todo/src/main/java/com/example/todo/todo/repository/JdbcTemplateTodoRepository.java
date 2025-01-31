package com.example.todo.todo.repository;

import com.example.todo.todo.dto.TodoDetail;
import com.example.todo.todo.dto.TodoUpdateRequest;
import com.example.todo.todo.domain.Todo;
import com.example.todo.exception.ExceptionType;
import com.example.todo.exception.TodoException;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public List<TodoDetail> findAllByUserId(Long userId) {
        String sql = "select * from todos join users u on todos.user_id = u.id where todos.user_id = ?";
        return jdbcTemplate.query(sql, todoDatailRowMapper(), userId);
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

    /** Lv.1 구현
     @Override
     public List<Todo> findAllByUpdatedAtAndAuthorName(LocalDate updateAt, String authorName) {
     StringBuilder sql = new StringBuilder("select * from todos ");
     if(updateAt==null && authorName==null) {
     sql.append("order by updated_at desc");
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
     sql.append("order by updated_at desc");

     log.info("sql : {}",sql);
     log.info("params = {}",params);
     return jdbcTemplate.query(sql.toString(), todoRowMapper(), params.toArray());
     } **/
}
