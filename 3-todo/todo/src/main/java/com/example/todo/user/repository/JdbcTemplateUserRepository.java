package com.example.todo.user.repository;

import com.example.todo.exception.ExceptionType;
import com.example.todo.exception.TodoException;
import com.example.todo.user.domain.User;
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

@Repository
public class JdbcTemplateUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert insertActor;

    public JdbcTemplateUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.insertActor = new SimpleJdbcInsert(dataSource)
                .withTableName("users")
                .usingGeneratedKeyColumns("id")
                .usingColumns("name","email");
    }

    @Override
    public Long saveAndReturnKey(User user) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("name",user.getName());
        parameters.put("email",user.getEmail());

        Number key = insertActor.executeAndReturnKey(parameters);

        return key.longValue();
    }

    @Override
    public Optional<User> findById(Long id) {
        String sql = "select * from users where id = ?";
        List<User> result = jdbcTemplate.query(
                sql,
                userRowMapper(),
                id
        );
        return result.stream().findAny();
    }

    @Override
    public Optional<User> findByEmail(String email) {
        String sql = "select * from users where email = ?";
        List<User> result = jdbcTemplate.query(
                sql,
                userRowMapper(),
                email
        );
        return result.stream().findAny();
    }

    @Override
    public void updateName(Long id, String name) {
        String sql = "update users set name = ? where id = ?";
        jdbcTemplate.update(sql,
                name,
                id
        );
    }

    private RowMapper<User> userRowMapper() {
        return new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                return User.builder()
                        .id(rs.getLong("id"))
                        .name(rs.getString("name"))
                        .email(rs.getString("email"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();
            }
        };
    }
}
