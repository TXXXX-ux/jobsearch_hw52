package kg.attractor.movie_riviewer.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import kg.attractor.movie_riviewer.model.User;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void save(User user) {
        String sql = "INSERT INTO users (name, surname, age, email, password, phone_number) " +
                "VALUES (:name, :surname, :age, :email, :password, :phone)";

        Map<String, Object> params = Map.of(
                "name", user.getName(),
                "surname", user.getSurname(),
                "age", user.getAge() == null ? 0 : user.getAge(),
                "email", user.getEmail(),
                "password", user.getPassword() == null ? "" : user.getPassword(),
                "phone", user.getPhoneNumber() == null ? "" : user.getPhoneNumber()
        );
        jdbcTemplate.update(sql, params);
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = :email";
        try {
            User user = jdbcTemplate.queryForObject(sql, Map.of("email", email),
                    new BeanPropertyRowMapper<>(User.class));
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public Optional<User> findByPhone(String phone) {
        String sql = "SELECT * FROM users WHERE phone = :phone";
        try {
            User user = jdbcTemplate.queryForObject(sql, Map.of("phone", phone),
                    new BeanPropertyRowMapper<>(User.class));
            return Optional.ofNullable(user);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}